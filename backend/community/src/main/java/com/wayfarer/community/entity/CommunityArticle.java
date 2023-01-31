package com.wayfarer.community.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    private String topic;

    @Column
    private String comment;

    @Column
    private String replyComment;

    @Column
    private Boolean enabled;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    public void changeEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
