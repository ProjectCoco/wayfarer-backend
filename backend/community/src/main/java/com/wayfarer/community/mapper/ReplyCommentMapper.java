package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;
import com.wayfarer.community.entity.CommunityComment;
import com.wayfarer.community.entity.ReplyComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReplyCommentMapper {

    @Mapping(source = "replyCommentRequestDto.content", target = "content")
    @Mapping(source = "communityComment", target = "communityComment")
    ReplyComment replyCommentRequestDtoToReplyComment(ReplyCommentRequestDto replyCommentRequestDto, CommunityComment communityComment);

}
