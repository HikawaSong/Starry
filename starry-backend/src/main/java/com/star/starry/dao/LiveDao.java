package com.star.starry.dao;

import com.star.starry.model.entity.Live;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LiveDao extends JpaRepository<Live, String> {

    List<Live> findByIdIn(Collection<String> idList);

    List<Live> findByIdNotIn(Collection<String> idList, Pageable pageable);

    Page<Live> findAll(Pageable pageable);
}
