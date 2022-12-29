package com.wayfarer.project.entity.enummodel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProjectSkillEnum {
    SPRINGBOOT("SpringBoot"),
    REACT("React"),
    SPRING("Spring"),
    PYTHON("Python"),
    AWS("Aws"),
    GIT("Git"),
    IOS("IOS"),
    HTML("HTML"),
    JAVASCRIPT("JavaScript"),
    MYSQL("MySql"),
    LINUX("Linux"),
    ANDROID("Android"),
    KOTLIN("Kotlin"),
    SWIFT("Swift"),
    PHP("PHP"),
    DOCKER("Docker"),
    JPA("JPA"),
    RUST("Rust");

    private final String value;
}
