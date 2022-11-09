package com.wayfarer.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleUpdateRequestDto {

    private String target;
    private String title;
    private String content;
    private String purpose;
    private String meetTime;



}