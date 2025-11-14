package com.star.starry.service;

import com.star.starry.dao.CommentDao;
import com.star.starry.model.comment.Comment;
import com.star.starry.model.comment.CommentThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private static final Integer REPLIES_NUM = 2;
    private static final String LIKES_COUNT = "likeCount";
    @Autowired
    private CommentDao commentDao;

    public List<CommentThread> getFirstComments(String eventId, Integer parentNum){

        var pageRequest = PageRequest.of(0, parentNum, Sort.by(Sort.Order.desc(LIKES_COUNT)));
        var parentList = commentDao.findByOrderByLikeCountDesc(pageRequest);

        List<String> parentIdList = parentList.stream().map(Comment::getId).toList();
        commentDao.findByParentIdIn(parentIdList);

        return null;
    }


}
