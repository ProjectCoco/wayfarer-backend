package com.wayfarer.study.repository;

import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.entity.vo.StudyPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyArticleRepository extends JpaRepository<StudyArticle, Long> {

    Page<StudyArticle> findByStudyTagsContainsAndEnabled(String tag, Boolean enabled, Pageable pageable);

    Page<StudyArticle> findByStudyPositionAndEnabled(StudyPosition studyPosition, Boolean enabled, Pageable pageable);
}
