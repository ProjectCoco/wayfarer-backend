package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;
import com.wayfarer.community.entity.CommunityComment;
import com.wayfarer.community.entity.ReplyComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReplyCommentMapper {

    ReplyComment replyCommentRequestDtoToReplyComment(ReplyCommentRequestDto replyCommentRequestDto, CommunityComment communityComment);
}
