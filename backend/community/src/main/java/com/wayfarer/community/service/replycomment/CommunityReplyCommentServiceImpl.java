package com.wayfarer.community.service.replycomment;

import com.wayfarer.common.exception.BusinessException;
import com.wayfarer.common.exception.ExceptionCode;
import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;
import com.wayfarer.community.entity.CommunityComment;
import com.wayfarer.community.entity.ReplyComment;
import com.wayfarer.community.mapper.ReplyCommentMapper;
import com.wayfarer.community.repository.CommunityCommentRepository;
import com.wayfarer.community.repository.CommunityReplyCommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommunityReplyCommentServiceImpl implements CommunityReplyCommentService{

    private final CommunityReplyCommentRepository communityReplyCommentRepository;

    private final CommunityCommentRepository communityCommentRepository;

    private final ReplyCommentMapper replyCommentMapper;

    public CommunityReplyCommentServiceImpl(CommunityReplyCommentRepository communityReplyCommentRepository, CommunityCommentRepository communityCommentRepository, ReplyCommentMapper replyCommentMapper) {
        this.communityReplyCommentRepository = communityReplyCommentRepository;
        this.communityCommentRepository = communityCommentRepository;
        this.replyCommentMapper = replyCommentMapper;
    }

    @Override
    public void postReplyComment(Long commentId, ReplyCommentRequestDto replyCommentRequestDto) {
        CommunityComment communityComment = communityCommentRepository.getReferenceById(commentId);
        ReplyComment replyComment = replyCommentMapper.replyCommentRequestDtoToReplyComment(replyCommentRequestDto, communityComment);
        communityReplyCommentRepository.save(replyComment);
    }

    @Override
    public void updateReplyComment(Long replyCommentId, ReplyCommentRequestDto replyCommentRequestDto) {
        ReplyComment replyComment = communityReplyCommentRepository.getReferenceById(replyCommentId);
        replyComment.setContent(replyCommentRequestDto.getContent());
        communityReplyCommentRepository.save(replyComment);
    }

    @Override
    public void deleteReplyComment(Long replyCommentId) {
        ReplyComment replyComment = communityReplyCommentRepository.findById(replyCommentId).orElseThrow(() -> new BusinessException(ExceptionCode.REPLY_COMMENT_NOT_FOUND));
        replyComment.setContent("삭제된 댓글입니다.");
    }
}
