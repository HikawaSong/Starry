package com.star.starry.model.comment;

import com.star.starry.model.common.BaseDto;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Comment extends BaseDto {
    private String liveId;
    private String postId;
    private String parentId;
    private String authorId;
    private String content;
    private Integer likeCount;
    private Integer replyCount;
    private Integer status;
}
