package com.wayfarer.community.service.replycomment;

import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;

public interface CommunityReplyCommentService {

    void postReplyComment(Long commentId, ReplyCommentRequestDto replyCommentRequestDto);

    void updateReplyComment(Long replyCommentId, ReplyCommentRequestDto replyCommentRequestDto);

    void deleteReplyComment(Long replyCommentId);
}
