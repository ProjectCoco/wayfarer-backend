package com.wayfarer.community.service.article;

import com.wayfarer.community.dto.*;
import com.wayfarer.community.dto.article.CommunityArticleDetailResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleRequestDto;
import com.wayfarer.community.dto.article.CommunityArticleResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleUpdateRequestDto;
import com.wayfarer.community.entity.ArticleTopic;
import com.wayfarer.community.entity.CommunityArticle;
import com.wayfarer.community.mapper.CommunityMapper;
import com.wayfarer.community.repository.ArticleTopicRepository;
import com.wayfarer.community.repository.CommunityArticleRepository;
import com.wayfarer.community.repository.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityArticleRepository communityArticleRepository;
    private final CommunityMapper communityMapper;
    private final ArticleTopicRepository articleTopicRepository;
    private final TopicRepository topicRepository;

    public CommunityServiceImpl(CommunityArticleRepository communityArticleRepository,
                                CommunityMapper communityMapper,
                                ArticleTopicRepository articleTopicRepository, TopicRepository topicRepository) {
        this.communityArticleRepository = communityArticleRepository;
        this.communityMapper = communityMapper;
        this.articleTopicRepository = articleTopicRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public MultiResponseDto<CommunityArticleResponseDto> readAllCommunityArticles(int page) {
        Page<CommunityArticle> communityArticles = communityArticleRepository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("communityArticleId").descending()));
        List<CommunityArticleResponseDto> communityArticleResponseDtos =
                communityMapper.communityArticlesToCommunityArticleResponseDtos(communityArticles.getContent());
        return new MultiResponseDto<>(communityArticleResponseDtos, communityArticles);
    }

    @Override
    public CommunityArticleDetailResponseDto readCommunityArticle(Long communityId) {
        CommunityArticle communityArticle = communityArticleRepository.findById(communityId)
                .orElseThrow(NullPointerException::new);
        return communityMapper.communityArticleToCommunityArticleDetailResponseDto(communityArticle);
    }

    @Override
    @Transactional
    public void createCommunityArticle(CommunityArticleRequestDto communityArticleRequestDTO) {
        CommunityArticle communityArticle = communityMapper.communityArticleRequestDtoToCommunityArticle(communityArticleRequestDTO);
        CommunityArticle savedCommunityArticle = communityArticleRepository.save(communityArticle);

        communityArticleRequestDTO.getTopics().forEach(id -> {
                    try {
                        articleTopicRepository.save(
                                ArticleTopic.builder()
                                        .topic(topicRepository.getReferenceById(id))
                                        .communityArticle(savedCommunityArticle).build())
                        ;
                    } catch (RuntimeException runtimeException) {
                        throw new NullPointerException("존재하지 않는 토픽" + id);
                    }
                }
        );

    }

    @Override
    public void updateCommunityArticle(Long communityId, CommunityArticleUpdateRequestDto communityArticleUpdateRequestDTO) {
        CommunityArticle communityArticle = communityArticleRepository.findById(communityId).orElseThrow(NullPointerException::new);
        // Topic 변경 로직
        communityArticle.updateAll(communityArticleUpdateRequestDTO);
        communityArticleRepository.save(communityArticle);
    }

    @Override
    public void deleteCommunityArticle(Long communityId) {
        CommunityArticle communityArticle = communityArticleRepository.findById(communityId).orElseThrow(NullPointerException::new);
        communityArticle.changeEnabled(false);
        communityArticleRepository.save(communityArticle);
    }
}
