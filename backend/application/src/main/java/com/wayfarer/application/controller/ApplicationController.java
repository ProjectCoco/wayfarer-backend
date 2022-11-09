package com.wayfarer.application.controller;

import com.wayfarer.study.dto.StudyArticleRequestDto;
import com.wayfarer.study.dto.StudyArticleUpdateRequestDto;
import com.wayfarer.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class ApplicationController {

    private final StudyService studyService;

    @GetMapping("")
    //todo page
    public ResponseEntity readAllStudy(@RequestParam int page) {
        return new ResponseEntity<>(studyService.readAllStudyArticles(page), HttpStatus.OK);
    }

    @GetMapping("/{studyId}")
    public ResponseEntity readStudy(@PathVariable Long studyId) {
        return new ResponseEntity<>(studyService.readStudyArticle(studyId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createStudy(@RequestBody StudyArticleRequestDto studyArticleRequestDto) {
        studyService.createStudyArticle(studyArticleRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{studyId}")
    public ResponseEntity updateStudy(@PathVariable Long studyId,
                                      @RequestBody StudyArticleUpdateRequestDto studyArticleUpdateRequestDto) {
        //target -> info, title, tag, time, contents, ....
        studyService.updateStudyArticle(studyId, studyArticleUpdateRequestDto);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("/{studyId}")
    public ResponseEntity deleteSutdy(@PathVariable Long studyId) {
        //delete -> status 변경
        studyService.deleteStudyArticle(studyId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
