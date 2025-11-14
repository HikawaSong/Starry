package com.star.starry.dao;

import com.star.starry.model.comment.Comment;
import com.star.starry.model.live.LiveStatic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CommentDao extends JpaRepository<Comment, String> {

    List<Comment> findByOrderByLikeCountDesc(Pageable pageable);

    List<Comment> findByParentIdIn(Collection<String> parentIdList);
}
