package com.star.starry.dao;

import com.star.starry.model.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, String> {


}
