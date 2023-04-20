package com.wayfarer.community.dto.replycomment;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyCommentResponseDto {

    private Long replyCommentId;

    private String content;

    private LocalDateTime createdTime;
}
