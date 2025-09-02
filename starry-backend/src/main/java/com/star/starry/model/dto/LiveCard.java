package com.star.starry.model.dto;
import com.star.starry.model.entity.Live;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LiveCard {
    public String title;
    private String place;
    private String venue;
    public String url;

    public static LiveCard fromLive(Live live){
        return LiveCard.builder()
                .title(live.getTitle())
                .place(live.getPlace())
                .venue(live.getVenue())
                 .build();
    }
}
