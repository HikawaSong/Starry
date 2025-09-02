package com.star.starry.service;

import com.star.starry.dao.LiveDao;
import com.star.starry.dao.LiveImageDao;
import com.star.starry.dao.LiveStaticDao;
import com.star.starry.model.dto.LiveCard;
import com.star.starry.model.entity.Live;
import com.star.starry.model.entity.LiveImage;
import com.star.starry.model.entity.LiveStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LiveService {
    @Autowired
    private LiveStaticDao liveStaticDao;

    @Autowired
    private LiveDao liveDao;

    @Autowired
    private LiveImageDao liveImageDao;

    @Autowired
    private ImageUrlService imageUrlService;

    public List<LiveCard> getHotLives(int n){
        var pageRequest = PageRequest.of(0, n, Sort.by(Sort.Order.desc("viewsCount")));
        var topLiveStaticList = liveStaticDao.findByOrderByViewsCountDesc(pageRequest);
        var hotLiveIdList = topLiveStaticList.stream().map(LiveStatic::getId).toList();
        var hotLiveList = liveDao.findByIdIn(hotLiveIdList);

        List<LiveCard> list = new ArrayList<>();
        for (Live live : hotLiveList) {
            var imgKey = live.getImgKey();
            var imgUrl = imageUrlService.url(imgKey);
            var liveCard = LiveCard.fromLive(live);
            liveCard.setUrl(imgUrl);
            list.add(liveCard);
        }

        return list;

    }
}
