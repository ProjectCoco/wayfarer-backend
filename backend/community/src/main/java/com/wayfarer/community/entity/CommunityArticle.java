package com.wayfarer.community.entity;

import com.wayfarer.common.audit.Auditable;
import com.wayfarer.community.dto.article.CommunityArticleUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityArticle extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communityArticleId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private Boolean enabled = Boolean.TRUE;

    @OneToMany(mappedBy = "communityArticle", cascade = CascadeType.ALL)
    private List<ArticleTopic> articleTopics = new ArrayList<>();

    @OneToMany(mappedBy = "communityArticle", cascade = CascadeType.ALL)
    private List<CommunityComment> communityComments = new ArrayList<>();

    public void changeEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void updateAll(CommunityArticleUpdateRequestDto communityArticleUpdateRequestDTO) {
        this.title = communityArticleUpdateRequestDTO.getTitle();
        this.content = communityArticleUpdateRequestDTO.getContent();
    }
}
