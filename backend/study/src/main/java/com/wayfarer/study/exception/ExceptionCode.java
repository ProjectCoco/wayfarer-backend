package com.wayfarer.study.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    STUDY_ARTICLE_NOT_FOUND(404, "Study 게시글을 찾을 수 없습니다.")
    ;
    private int status;

    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
