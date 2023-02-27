package com.wayfarer.community.service.comment;

import com.wayfarer.community.dto.comment.CommunityCommentRequestDto;


public interface CommunityCommentService {

    void postComment(Long communityId, CommunityCommentRequestDto communityCommentRequestDto);

    void deleteComment(Long communityCommentId);

    void updateComment(Long commentId, CommunityCommentRequestDto communityCommentRequestDto);
}
