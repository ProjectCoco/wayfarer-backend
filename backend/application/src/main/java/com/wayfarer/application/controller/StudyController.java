package com.wayfarer.application.controller;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final StudyService studyService;

    @GetMapping("")
    //todo page
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readAllStudy(@RequestParam int page) {
        return new ResponseEntity<>(studyService.readAllStudyArticles(page), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readStudyWithTag(@RequestParam int page,
                                           @RequestParam(required = true) String tag) {
        return new ResponseEntity<>(studyService.readStudyArticlesWithTag(page, tag), HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readStudyWithPosition(@RequestParam int page,
                                                @RequestParam(required = true) String position) {
        return new ResponseEntity<>(studyService.readStudyArticlesWithPosition(page, position), HttpStatus.OK);
    }

    @GetMapping("/{studyId}")
    public ResponseEntity<StudyArticleDetailResponseDto> readStudy(@PathVariable Long studyId) {
        return new ResponseEntity<>(studyService.readStudyArticle(studyId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createStudy(@RequestBody StudyArticleRequestDto studyArticleRequestDto) {
        studyService.createStudyArticle(studyArticleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{studyId}")
    public ResponseEntity<Void> updateStudy(@PathVariable Long studyId,
                                      @RequestBody StudyArticleUpdateRequestDto studyArticleUpdateRequestDto) {
        //target -> info, title, tag, time, contents, ....
        studyService.updateStudyArticle(studyId, studyArticleUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/{studyId}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long studyId) {
        //delete -> status 변경
        studyService.deleteStudyArticle(studyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
