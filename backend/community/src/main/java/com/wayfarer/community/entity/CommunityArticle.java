package com.wayfarer.community.entity;

import com.wayfarer.community.dto.article.CommunityArticleUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CommunityArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communityArticleId;

    @Column()
    private String title;

    @Column
    private String content;

    @Column
    private Boolean enabled = Boolean.TRUE;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

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
