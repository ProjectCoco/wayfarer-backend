package com.wayfarer.application.controller;

import com.wayfarer.study.dto.StudyResponseDto;
import com.wayfarer.study.repository.StudyArticleRepository;
import com.wayfarer.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class ApplicationController {

    private final StudyService studyService;

    @GetMapping("")
    public ResponseEntity<List<StudyResponseDto>> readAllStudy() {
        return new ResponseEntity<>(studyService.readAllStudyArticles(), HttpStatus.OK);
    }
}
