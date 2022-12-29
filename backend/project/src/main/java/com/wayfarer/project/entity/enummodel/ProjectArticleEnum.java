package com.wayfarer.project.entity.enummodel;


public enum ProjectArticleEnum {
    PROJECT_ARTICLE_ID("projectArticleId"),
    TITLE("title"),
    STATUS("status"),
    PROJECT_COUNT_MEMBER("countMember"),
    PROJECT_TOTAL_MEMBER("totalMember"),
    PROJECT_CONTENT("projectContent"),
    CONTENT("content"),
    PROJECT_TIME("projectTime"),
    DEAD_LINE("deadLine"),
    PROJECT_INFO("projectInfo"),
    ENABLED("active"),
    PROJECT_TAGS("projectTags"),
    PROJECT_OWNER("projectOwner");

    private final String value;

    ProjectArticleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

