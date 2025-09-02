package com.star.starry.model.entity;

import com.star.starry.model.common.BaseDto;
import com.star.starry.model.common.ImageType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class LiveImage extends BaseDto {

    private String liveId;

    private ImageType imageType;

    private String alt;

    private int sortOrder;

}
