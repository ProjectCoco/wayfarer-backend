package com.wayfarer.application.controller;

import com.wayfarer.community.dto.comment.CommunityCommentRequestDto;
import com.wayfarer.community.dto.replycomment.ReplyCommentRequestDto;
import com.wayfarer.community.service.comment.CommunityCommentService;
import com.wayfarer.community.service.replycomment.CommunityReplyCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommunityCommentController {

    private final CommunityCommentService commentService;

    private final CommunityReplyCommentService replyCommentService;

    public CommunityCommentController(CommunityCommentService commentService, CommunityReplyCommentService replyCommentService) {
        this.commentService = commentService;
        this.replyCommentService = replyCommentService;
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId,
                                              @RequestBody CommunityCommentRequestDto communityCommentRequestDto) {
        commentService.updateComment(commentId, communityCommentRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{commentId}/reply")
    public ResponseEntity<Void> createReplyComment(@PathVariable Long commentId,
                                                   @RequestBody ReplyCommentRequestDto replyCommentRequestDto) {
        replyCommentService.postReplyComment(commentId, replyCommentRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
