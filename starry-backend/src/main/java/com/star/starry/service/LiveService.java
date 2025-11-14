package com.star.starry.service;

import com.star.starry.dao.LiveDao;
import com.star.starry.dao.LiveImageDao;
import com.star.starry.dao.LiveStaticDao;
import com.star.starry.model.live.LiveCard;
import com.star.starry.model.live.Live;
import com.star.starry.model.live.LiveStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LiveService {
    private static final String VIEWS_COUNT = "viewsCount";

    @Autowired
    private LiveStaticDao liveStaticDao;

    @Autowired
    private LiveDao liveDao;

    @Autowired
    private LiveImageDao liveImageDao;

    @Autowired
    private ImageUrlService imageUrlService;

    public List<LiveCard> getHotLives(int n){
        var topLivePageRequest = PageRequest.of(0, n, Sort.by(Sort.Order.desc(VIEWS_COUNT)));
        var topLiveStaticList = liveStaticDao.findByOrderByViewsCountDesc(topLivePageRequest);
        var hotLiveIdList = topLiveStaticList.stream().map(LiveStatic::getId).toList();
        var hotLiveList = liveDao.findByIdIn(hotLiveIdList);
        var randomLiveCount = n - hotLiveList.size();
        List<Live> randomLiveList = new ArrayList<>();
        PageRequest randomLivePageRequest = PageRequest.of(0, n);
        if (hotLiveList.isEmpty()){
            randomLiveList = liveDao.findAll(randomLivePageRequest).getContent();
        }else if (randomLiveCount > 0){
            randomLiveList = liveDao.findByIdNotIn(hotLiveIdList, randomLivePageRequest);
        }
        hotLiveList.addAll(randomLiveList);

        List<LiveCard> resultList = new ArrayList<>();
        for (Live live : hotLiveList) {
            var imgKey = live.getImgKey();
            var imgUrl = imageUrlService.url(imgKey);
            var liveCard = LiveCard.fromLive(live);
            liveCard.setUrl(imgUrl);
            resultList.add(liveCard);
        }

        return resultList;

    }

    public void importLives(List<Live> liveList) {
        liveDao.saveAll(liveList);
    }
}
