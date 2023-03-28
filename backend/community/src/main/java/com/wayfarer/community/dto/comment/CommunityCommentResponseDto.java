package com.wayfarer.community.dto.comment;


import com.wayfarer.community.dto.replycomment.ReplyCommentResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommunityCommentResponseDto {

    private Long commentId;

    private String content;

    private LocalDateTime createdTime;

    private List<ReplyCommentResponseDto> replyComments;
}
