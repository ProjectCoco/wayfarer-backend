package com.wayfarer.community.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTopic {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "communityArticle_id")
    private CommunityArticle communityArticle;


    @Builder
    public ArticleTopic(Topic topic, CommunityArticle communityArticle){
        this.topic =topic;
        this.communityArticle = communityArticle;
    }
}
