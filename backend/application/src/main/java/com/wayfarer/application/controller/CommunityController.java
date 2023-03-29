package com.wayfarer.application.controller;

import com.wayfarer.common.dto.MultiResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleDetailResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleRequestDto;
import com.wayfarer.community.dto.article.CommunityArticleResponseDto;
import com.wayfarer.community.dto.article.CommunityArticleUpdateRequestDto;
import com.wayfarer.community.dto.comment.CommunityCommentRequestDto;
import com.wayfarer.community.service.article.CommunityService;
import com.wayfarer.community.service.comment.CommunityCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    private final CommunityCommentService commentService;

    public CommunityController(CommunityService communityService,
                               CommunityCommentService commentService) {
        this.communityService = communityService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public ResponseEntity<MultiResponseDto<CommunityArticleResponseDto>> readAllCommunity(@RequestParam int page) {
        return new ResponseEntity<>(communityService.readAllCommunityArticles(page), HttpStatus.OK);
    }

    @GetMapping("/{communityId}")
    public ResponseEntity<CommunityArticleDetailResponseDto> readCommunity(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityService.readCommunityArticle(communityId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createCommunity(@RequestBody CommunityArticleRequestDto communityArticleRequestDto) {
        communityService.createCommunityArticle(communityArticleRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{communityId}")
    public ResponseEntity<Void> putCommunity(@PathVariable Long communityId,
                                           @RequestBody CommunityArticleUpdateRequestDto communityArticleUpdateRequestDto) {
        communityService.updateCommunityArticle(communityId, communityArticleUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/{communityId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long communityId) {
        //delete -> status 변경
        communityService.deleteCommunityArticle(communityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{communityId}/comment")
    public ResponseEntity<Void> createComment(@PathVariable Long communityId,
                                              @RequestBody CommunityCommentRequestDto communityCommentRequestDto) {
        commentService.postComment(communityId, communityCommentRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
