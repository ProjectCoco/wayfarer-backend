package com.wayfarer.member.oauth.entity;

import lombok.Getter;

@Getter
public enum ProviderType {
    GOOGLE("google", "구글 로그인"),
    KAKAO("kakao", "카카오 로그인"),
    NAVER("naver", "네이버 로그인");

    final String providerId;
    final String decription;

    ProviderType(String providerId, String decription) {
        this.providerId = providerId;
        this.decription = decription;
    }
}
