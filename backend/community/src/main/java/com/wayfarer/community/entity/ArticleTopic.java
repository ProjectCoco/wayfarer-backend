package com.wayfarer.community.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
