package com.wayfarer.community.service;

import com.wayfarer.community.dto.CommunityCommentRequestDto;


public interface CommunityCommentService {

    void postComment(Long communityId, CommunityCommentRequestDto communityCommentRequestDto);

    void deleteComment(Long communityCommentId);

    void updateComment(Long commentId, CommunityCommentRequestDto communityCommentRequestDto);
}
