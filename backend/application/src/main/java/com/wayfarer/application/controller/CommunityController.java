package com.wayfarer.application.controller;

import com.wayfarer.community.dto.*;
import com.wayfarer.community.service.CommunityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("")
    public ResponseEntity<MultiResponseDto<CommunityArticleResponseDto>> readAllCommunity(@RequestParam int page) {
        return new ResponseEntity<>(communityService.readAllCommunityArticles(page), HttpStatus.OK);
    }

    @GetMapping("/{communityId}")
    public ResponseEntity<CommunityArticleDetailResponseDto> readAllCommunity(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityService.readCommunityArticle(communityId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createCommunity(@RequestBody CommunityArticleRequestDto communityArticleRequestDto) {
        communityService.createCommunityArticle(communityArticleRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{communityId}")
    public ResponseEntity<Void> putProject(@PathVariable Long communityId,
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
}
