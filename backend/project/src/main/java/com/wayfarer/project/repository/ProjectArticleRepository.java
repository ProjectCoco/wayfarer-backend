package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.vo.ProjectInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectArticleRepository extends JpaRepository<ProjectArticle, Long> {

    Page<ProjectArticle> findByEnabled(Boolean enabled, Pageable pageable);

    Page<ProjectArticle> findByEnabledAndProjectInfo(boolean enabled, ProjectInfo projectInfo, Pageable pageable);
}
