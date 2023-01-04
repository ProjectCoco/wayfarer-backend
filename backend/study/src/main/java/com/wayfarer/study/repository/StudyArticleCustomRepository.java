package com.wayfarer.study.repository;

import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyArticleCustomRepository {

    Page<StudyArticle> getByPositionAndStatus(StudyStatus status, String position , Pageable pageable);
}
