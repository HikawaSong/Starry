package com.star.starry.model.entity;

import com.star.starry.model.common.BaseDto;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

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
    private List<String> artists;
    private LocalDate date;
    private String imgKey;


}
