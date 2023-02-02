package com.wayfarer.member.entity;

import com.wayfarer.member.oauth.entity.ProviderType;
import com.wayfarer.member.oauth.entity.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100, unique = true, nullable = false)
    private String socialId;
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String profileImageUrl;

    @Column
    private String position;

    @Column
    private Boolean receiveMarketing;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProviderType providerType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    public Member(String socialId, String username, String profileImageUrl) {
        this.socialId = socialId;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
    }

    public Member(String socialId, String email, String profileImageUrl, ProviderType providerType, RoleType roleType) {
        this.socialId = socialId;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
    }
}