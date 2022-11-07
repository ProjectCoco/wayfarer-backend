package com.wayfarer.study.config;

import com.wayfarer.study.mapper.StudyMapper;
import com.wayfarer.study.repository.StudyArticleRepository;
import com.wayfarer.study.service.StudyService;

import com.wayfarer.study.service.StudyServiceImpl;
import com.wayfarer.study.service.StudyServiceMockImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
public class StudyConfiguration {

    private final StudyArticleRepository studyArticleRepository;
    private final StudyMapper studyMapper;

    @Bean
    public StudyService studyServiceMock() {
        return new StudyServiceMockImpl();
    }

    @Primary
    @Bean
    public StudyService studyService() {
        return new StudyServiceImpl(studyArticleRepository, studyMapper);
    }
}
