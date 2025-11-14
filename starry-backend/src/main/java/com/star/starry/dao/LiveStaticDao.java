package com.star.starry.dao;

import com.star.starry.model.live.LiveStatic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveStaticDao extends JpaRepository<LiveStatic, String> {

    List<LiveStatic> findByOrderByViewsCountDesc(Pageable pageable);


}
