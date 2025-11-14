package com.star.starry.dao;

import com.star.starry.model.live.LiveImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LiveImageDao extends JpaRepository<LiveImage, String> {

    List<LiveImage> findByLiveIdIn(Collection<String> liveIds);
}
