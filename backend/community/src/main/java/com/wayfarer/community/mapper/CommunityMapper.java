package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.article.CommunityArticleDetailResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleRequestDto;
import com.wayfarer.community.dto.article.CommunityArticleResponseDto;
import com.wayfarer.community.entity.CommunityArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommonCommunityMapper.class)
public interface CommunityMapper {

    CommunityArticle communityArticleRequestDtoToCommunityArticle(CommunityArticleRequestDto communityArticleRequestDTO);

    @Mapping(source = "communityComments", target = "comments")
    CommunityArticleDetailResponseDto communityArticleToCommunityArticleDetailResponseDto(CommunityArticle communityArticle);

    CommunityArticleResponseDto communityArticleToCommunityArticleResponseDto(CommunityArticle communityArticle);

    List<CommunityArticleResponseDto> communityArticlesToCommunityArticleResponseDtos(List<CommunityArticle> content);
}
