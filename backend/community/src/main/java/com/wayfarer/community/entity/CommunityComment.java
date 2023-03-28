package com.wayfarer.community.entity;

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
public class CommunityComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_article_id")
    private CommunityArticle communityArticle;

    @OneToMany(mappedBy = "communityComment", cascade = CascadeType.ALL)
    private List<ReplyComment> replyComments = new ArrayList<>();

    @Column
    private String content;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    @Column()
    private Boolean enabled;
}
