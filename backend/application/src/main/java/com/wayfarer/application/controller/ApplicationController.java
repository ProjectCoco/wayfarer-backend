package com.wayfarer.application.controller;

import com.wayfarer.study.dto.StudyResponseDto;
import com.wayfarer.study.repository.StudyArticleRepository;
import com.wayfarer.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class ApplicationController {

    private final StudyService studyService;

    @GetMapping("")
    //todo page
    public ResponseEntity<List<StudyResponseDto>> readAllStudy() {
        return new ResponseEntity<>(studyService.readAllStudyArticles(), HttpStatus.OK);
    }

    @GetMapping("/{target}")
    public ResponseEntity readStudy(@PathVariable String target) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createStudy() {
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
