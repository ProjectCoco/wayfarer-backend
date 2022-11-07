package com.wayfarer.study.dto;

import com.wayfarer.study.entity.vo.StudyContent;
import com.wayfarer.study.entity.vo.StudyInfo;
import com.wayfarer.study.entity.vo.StudyOwner;
import com.wayfarer.study.entity.vo.StudyTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyArticleRequestDto {

    private String title;
    private String content;

    private String purpose;

    private String meetTime;


}
