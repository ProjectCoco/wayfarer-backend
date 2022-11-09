package com.wayfarer.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Builder
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyInfo {

    @Column()
    private String active;

}
