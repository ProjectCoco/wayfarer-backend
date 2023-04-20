package com.wayfarer.community.service.comment;

import com.wayfarer.community.dto.comment.CommunityCommentRequestDto;
import com.wayfarer.community.entity.CommunityArticle;
import com.wayfarer.community.entity.CommunityComment;
import com.wayfarer.community.mapper.CommunityCommentMapper;
import com.wayfarer.community.repository.CommunityArticleRepository;
import com.wayfarer.community.repository.CommunityCommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommunityCommentServiceImpl implements CommunityCommentService{

    private final CommunityCommentRepository communityCommentRepository;
    private final CommunityArticleRepository communityArticleRepository;

    private final CommunityCommentMapper communityCommentMapper;

    public CommunityCommentServiceImpl(CommunityCommentRepository communityCommentRepository,
                                       CommunityArticleRepository communityArticleRepository,
                                       CommunityCommentMapper communityCommentMapper) {
        this.communityCommentRepository = communityCommentRepository;
        this.communityArticleRepository = communityArticleRepository;
        this.communityCommentMapper = communityCommentMapper;
    }
    @Override
    public void postComment(Long communityId, CommunityCommentRequestDto communityCommentRequestDto) {
        CommunityArticle communityArticle = communityArticleRepository.getReferenceById(communityId);
        CommunityComment communityComment = communityCommentMapper.communityCommentRequestDtoToCommunityComment(communityCommentRequestDto, communityArticle);
        communityCommentRepository.save(communityComment);
    }

    @Override
    public void updateComment(Long commentId, CommunityCommentRequestDto communityCommentRequestDto) {
        CommunityComment communityComment = communityCommentRepository.getReferenceById(commentId);
        communityComment.setContent(communityCommentRequestDto.getContent());
        communityCommentRepository.save(communityComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        CommunityComment communityComment = communityCommentRepository.findById(commentId).orElseThrow(NullPointerException::new);
        communityComment.setContent("삭제된 댓글입니다.");
    }
}
