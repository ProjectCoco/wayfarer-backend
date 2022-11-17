package com.wayfarer.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleRequestDto {

    private String title;
    private String content;
    private String meetTime;



}
