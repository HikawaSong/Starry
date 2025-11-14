package com.star.starry.model.live;

import com.star.starry.model.common.BaseDto;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Live extends BaseDto {
    private String title;
    private String place;
    private String venue;
    private LocalDate date;
    private String imgKey;
}
