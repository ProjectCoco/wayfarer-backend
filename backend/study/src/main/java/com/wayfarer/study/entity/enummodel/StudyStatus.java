package com.wayfarer.study.entity.enummodel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum StudyStatus {
    PROCEED("모집중"),
    COMPLETE("모집완료");

    private final String status;

    StudyStatus(String status){
        this.status = status;
    }
}
