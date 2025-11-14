package com.star.starry.model.live;


import com.star.starry.model.common.BaseDto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class LiveSchedule extends BaseDto {
    private String liveId;
    private LocalDate date;
    private String venue;
}
