package com.wayfarer.community.mapper;

import com.wayfarer.community.dto.CommunityArticleDetailResponseDto;
import com.wayfarer.community.dto.CommunityArticleRequestDto;
import com.wayfarer.community.dto.CommunityArticleResponseDto;
import com.wayfarer.community.entity.CommunityArticle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommonCommunityMapper.class)
public interface CommunityMapper {

    CommunityArticle communityArticleRequestDtoToCommunityArticle(CommunityArticleRequestDto communityArticleRequestDTO);

    CommunityArticleDetailResponseDto communityArticleToCommunityArticleDetailResponseDto(CommunityArticle communityArticle);

    CommunityArticleResponseDto communityArticleToCommunityArticleResponseDto(CommunityArticle communityArticle);

    List<CommunityArticleResponseDto> communityArticlesToCommunityArticleResponseDtos(List<CommunityArticle> content);
}
