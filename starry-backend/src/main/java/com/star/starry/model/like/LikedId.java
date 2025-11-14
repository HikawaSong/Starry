package com.star.starry.model.like;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class LikedId implements Serializable {
    @Enumerated(EnumType.STRING)
    private LikeTargetType targetType;
    private String targetId;
    private String userId;
}
