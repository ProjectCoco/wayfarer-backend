package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.comment.CommunityCommentRequestDto;
import com.wayfarer.community.entity.CommunityArticle;
import com.wayfarer.community.entity.CommunityComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommunityCommentMapper {

    @Mapping(source = "communityCommentRequestDto.content", target = "content")
    @Mapping(source = "communityArticle", target = "communityArticle")
    CommunityComment communityCommentRequestDtoToCommunityComment(CommunityCommentRequestDto communityCommentRequestDto, CommunityArticle communityArticle);

}
