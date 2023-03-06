package com.wayfarer.application.controller;

import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;
import com.wayfarer.community.service.replycomment.CommunityReplyCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
public class CommunityReplyCommentController {

    private final CommunityReplyCommentService replyCommentService;

    public CommunityReplyCommentController(CommunityReplyCommentService replyCommentService) {
        this.replyCommentService = replyCommentService;
    }

    @PutMapping("/reply/{replyId}")
    public ResponseEntity<Void> updateReplyComment(@PathVariable Long replyId,
                                                   @RequestBody ReplyCommentRequestDto replyCommentRequestDto) {
        replyCommentService.updateReplyComment(replyId, replyCommentRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<Void> deleteReplyComment(@PathVariable Long replyId) {
        replyCommentService.deleteReplyComment(replyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
