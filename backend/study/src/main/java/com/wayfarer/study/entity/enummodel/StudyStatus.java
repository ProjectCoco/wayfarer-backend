package com.wayfarer.study.entity.enummodel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum StudyStatus {
    PROCEED("PROCEED"),
    COMPLETE("COMPLETE");

    private final String status;

    StudyStatus(String status){
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
