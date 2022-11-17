package com.wayfarer.study.entity.enummodel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StudyStatus {
    PROCEED("모집중"),
    COMPLETE("모집완료");

    @Getter
    private final String status;
}
