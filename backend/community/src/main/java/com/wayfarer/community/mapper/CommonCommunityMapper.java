package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.comment.CommunityCommentResponseDto;
import com.wayfarer.community.dto.replycomment.ReplyCommentResponseDto;
import com.wayfarer.community.entity.CommunityComment;
import com.wayfarer.community.entity.ReplyComment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommonCommunityMapper {

    List<CommunityCommentResponseDto> communityCommentsToCommunityCommentResponseDtos(List<CommunityComment> communityComments);

    List<ReplyCommentResponseDto> replyCommentsToReplyCommentResponseDtos(List<ReplyComment> replyComments);
}
