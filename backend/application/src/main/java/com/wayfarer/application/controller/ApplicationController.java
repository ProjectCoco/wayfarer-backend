package com.wayfarer.application.controller;

import com.wayfarer.study.dto.StudyArticleRequestDto;
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

    @GetMapping("/{target}")
    public ResponseEntity readStudy(@PathVariable String target) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createStudy(@RequestBody StudyArticleRequestDto studyArticleRequestDto) {
        studyService.createStudyArticle(studyArticleRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/{target}")
    public ResponseEntity updateStudy(@PathVariable String target) {
        //target -> info, title, tag, time, contents, ....
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity deleteSutdy() {
        //delete -> status 변경
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
