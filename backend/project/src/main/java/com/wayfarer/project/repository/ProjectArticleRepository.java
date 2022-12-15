package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectArticleRepository extends JpaRepository<ProjectArticle, Long> {

    Page<ProjectArticle> findByEnabled(Boolean enabled, Pageable pageable);
}
