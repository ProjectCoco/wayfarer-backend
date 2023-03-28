package com.wayfarer.community.service.article;

import com.wayfarer.community.dto.*;
import com.wayfarer.community.dto.article.CommunityArticleDetailResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleRequestDto;
import com.wayfarer.community.dto.article.CommunityArticleResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleUpdateRequestDto;

public interface CommunityService {

    MultiResponseDto<CommunityArticleResponseDto> readAllCommunityArticles(int page);

    CommunityArticleDetailResponseDto readCommunityArticle(Long communityId);

    void createCommunityArticle(CommunityArticleRequestDto communityArticleRequestDTO);

    void updateCommunityArticle(Long communityId, CommunityArticleUpdateRequestDto communityArticleUpdateRequestDTO);

    void deleteCommunityArticle(Long communityId);

}
