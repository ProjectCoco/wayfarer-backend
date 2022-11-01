package com.wayfarer.study.repository;

import com.wayfarer.study.entity.StudyArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyArticleRepository extends JpaRepository<StudyArticle, Long> {
}
