package com.wayfarer.application.controller;

import com.wayfarer.study.service.StudyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final StudyService studyService;

    public TestController(StudyService studyService) {
        this.studyService = studyService;
    }

}
