package com.wayfarer.community.repository;

import com.wayfarer.community.entity.CommunityArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityArticleRepository extends JpaRepository<CommunityArticle, Long> {
}
