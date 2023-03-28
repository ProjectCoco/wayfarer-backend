package com.wayfarer.project.repository;

import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.vo.ProjectInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectArticleRepository extends JpaRepository<ProjectArticle, Long>, ProjectArticleCustomRepository {


    Page<ProjectArticle> getByEnabled(Boolean enabled, Pageable pageable);

    Page<ProjectArticle> findByEnabledAndProjectInfo(boolean enabled, ProjectInfo projectInfo, Pageable pageable);

    Page<ProjectArticle> findByProjectTagsContainsAndEnabledAndProjectInfo(String tag, boolean enabled, ProjectInfo projectInfo, Pageable pageable);

    Page<ProjectArticle> findByProjectTagsContainsAndEnabled(String tag, boolean enabled, Pageable pageable);

    @Query(value = "SELECT * FROM project_article where enabled='Y' order by RAND() limit 10", nativeQuery = true)
    List<ProjectArticle> findByRandomArticles();
}
