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
    private String contents;

    @Column
    private String topic;

    @Column
    private String comment;     //  1,2,3,5

    @Column
    private String replyComment;    //  2,5,6

    @Column
    private Boolean enabled;

    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    //제목
    //내용
    //태그
    //좋아요
    //댓글
}
