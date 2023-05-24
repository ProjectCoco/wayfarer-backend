package com.wayfarer.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    STUDY_ARTICLE_NOT_FOUND(404, "Study 게시글을 찾을 수 없습니다."),
    PROJECT_ARTICLE_NOT_FOUND(404, "Project 게시글을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(404, "Member를 찾을 수 없습니다."),
    COMMUNITY_ARTICLE_NOT_FOUND(404, "Community 게시글을 찾을 수 없습니다."),
    TOPIC_NOT_FOUND(404, "존재하지 않는 토픽입니다."),
    COMMENT_NOT_FOUND(404, "존재하지 않는 댓글입니다."),
    REPLY_COMMENT_NOT_FOUND(404, "존재하지 않는 답댓글입니다.")
    ;
    private int status;

    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
