package com.wayfarer.study.entity.enummodel;


public enum StudyArticleEnum {
    STUDY_ARTICLE_ID("studyArticleId"),
    TITLE("title"),
    STATUS("status"),
    STUDY_COUNT_MEMBER("countMember"),
    STUDY_TOTAL_MEMBER("totalMember"),
    STUDY_CONTENT("studyContent"),
    CONTENT("content"),
    STUDY_TIME("studyTime"),
    DEAD_LINE("deadLine"),
    STUDY_INFO("studyInfo"),
    ACTIVE("active"),
    STUDY_TAGS("studyTags"),
    STUDY_OWNER("studyOwner");

    private final String value;

    StudyArticleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

