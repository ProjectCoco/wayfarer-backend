package com.wayfarer.community.entity;

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
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    @Column(nullable = false, unique = true)
    private String topicName;

    @OneToMany(mappedBy = "topic", cascade = { CascadeType.REFRESH, CascadeType.PERSIST})
    public List<ArticleTopic> articleTopics = new ArrayList<>();
}
