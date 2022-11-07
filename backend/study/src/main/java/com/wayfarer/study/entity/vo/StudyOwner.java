package com.wayfarer.study.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StudyOwner {

    private Long ownerId;

}
