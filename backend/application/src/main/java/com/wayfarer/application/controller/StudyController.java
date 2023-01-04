package com.wayfarer.application.controller;

import com.wayfarer.study.dto.*;
import com.wayfarer.study.entity.enummodel.StudyStatus;
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
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readAllStudy(@RequestParam int page,
                                                                                  @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(studyService.readAllStudyArticles(page, status), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readStudyWithTag(@RequestParam int page,
                                                                                      @RequestParam(required = true) String tag,
                                                                                      @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(studyService.readStudyArticlesWithTag(page, tag, status), HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<MultiResponseDto<StudyArticleResponseDto>> readStudyWithPosition(@RequestParam int page,
                                                                                           @RequestParam(required = true) String position,
                                                                                           @RequestParam(required = false) StudyStatus status) {
        return new ResponseEntity<>(studyService.readStudyArticlesWithPosition(page, position, status), HttpStatus.OK);
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

    @PutMapping("/{studyId}")
    public ResponseEntity<Void> putStudy(@PathVariable Long studyId,
                                         @RequestBody StudyArticlePutRequestDto studyArticlePutRequestDto) {
        studyService.putStudyArticle(studyId, studyArticlePutRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
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
