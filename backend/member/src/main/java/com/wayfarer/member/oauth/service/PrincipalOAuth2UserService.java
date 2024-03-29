package com.wayfarer.member.oauth.service;


import com.wayfarer.member.entity.Member;
import com.wayfarer.member.oauth.entity.PrincipalDetails;
import com.wayfarer.member.oauth.entity.ProviderType;
import com.wayfarer.member.oauth.entity.RoleType;
import com.wayfarer.member.oauth.exception.OAuth2ProviderMissMatchException;
import com.wayfarer.member.oauth.info.OAuth2UserInfo;
import com.wayfarer.member.oauth.info.OAuth2UserInfoFactory;
import com.wayfarer.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return this.process(userRequest, oAuth2User);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) throws IOException {
        ProviderType providerType = ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());

        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
        Member savedUser = memberRepository.findBySocialId(userInfo.getId()).orElse(null);

        if (savedUser != null) {
            if (providerType != savedUser.getProviderType()) {
                throw new OAuth2ProviderMissMatchException(
                        "Looks like you're signed up with" + providerType + "account. please use your " + savedUser.getProviderType() + " account to login"
                );
            }

//            updateUser(savedUser, userInfo);
        } else {
            savedUser = createUser(userInfo, providerType);
        }

        return PrincipalDetails.create(savedUser, user.getAttributes());
    }

    private Member createUser(OAuth2UserInfo userInfo, ProviderType providerType) {
        Member user = new Member(
                userInfo.getId(),
                userInfo.getEmail(),
                userInfo.getImageUrl(),
                providerType,
                RoleType.USER
        );

        return memberRepository.saveAndFlush(user);
    }

    private Member updateUser(Member member, OAuth2UserInfo userInfo) {
        if (userInfo.getName() != null && !member.getUsername().equals(userInfo.getName())) {
            member.setUsername(userInfo.getName());
        }

        if (userInfo.getImageUrl() != null && !member.getProfileImageUrl().equals(userInfo.getImageUrl())) {
            member.setProfileImageUrl(userInfo.getImageUrl());
        }

        return member;
    }
}