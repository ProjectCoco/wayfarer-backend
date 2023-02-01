package com.wayfarer.community.service;

import com.wayfarer.community.dto.*;

public interface CommunityService {

    MultiResponseDto<CommunityArticleResponseDto> readAllCommunityArticles(int page);

    CommunityArticleDetailResponseDto readCommunityArticle(Long communityId);

    void createCommunityArticle(CommunityArticleRequestDto communityArticleRequestDTO);

    void updateCommunityArticle(Long communityId, CommunityArticleUpdateRequestDto communityArticleUpdateRequestDTO);

    void deleteCommunityArticle(Long communityId);

}
