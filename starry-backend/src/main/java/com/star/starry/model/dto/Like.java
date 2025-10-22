package com.star.starry.model.dto;

import com.star.starry.model.LikeTargetType;
import com.star.starry.model.LikedId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Like {
    @EmbeddedId
    private LikedId id;

    private Boolean  isActive;

    @CreatedDate
    private Instant createdAt;
}
