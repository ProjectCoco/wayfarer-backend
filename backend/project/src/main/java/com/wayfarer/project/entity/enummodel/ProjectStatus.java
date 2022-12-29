package com.wayfarer.project.entity.enummodel;

public enum ProjectStatus {

    PROCEED("모집중"),
    COMPLETE("모집완료");

    private final String status;

    ProjectStatus(String status){
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
