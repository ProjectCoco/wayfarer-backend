package com.wayfarer.study.entity.vo;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

@Builder
@Getter
@Embeddable
public class StudyOwner {

    private long ownerId;

}
