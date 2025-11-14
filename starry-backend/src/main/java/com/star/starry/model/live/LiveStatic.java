package com.star.starry.model.live;

import com.star.starry.model.common.BaseDto;
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
public class LiveStatic extends BaseDto {

    private int viewsCount;

    private int commentCount;

    private int likeAccount;

}
