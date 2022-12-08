package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectArticleRepository extends JpaRepository<ProjectArticle, Long> {
}
