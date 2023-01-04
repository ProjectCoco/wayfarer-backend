package com.wayfarer.study.repository;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wayfarer.study.entity.QStudyArticle;
import com.wayfarer.study.entity.QStudyMember;
import com.wayfarer.study.entity.StudyArticle;
import com.wayfarer.study.entity.enummodel.StudyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudyArticleCustomRepositoryImpl implements StudyArticleCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public StudyArticleCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QStudyArticle studyArticle = QStudyArticle.studyArticle;
    QStudyMember studyMember = QStudyMember.studyMember;


    @Override
    public Page<StudyArticle> getByPositionAndStatus(StudyStatus status, String position, Pageable pageable) {
        List<StudyArticle> studyArticles = jpaQueryFactory
                .select(studyArticle)
                .from(studyArticle)
                .join(studyMember)
                .on(studyMember.studyArticleId.eq(studyArticle.studyArticleId)
                        .and(studyMember.position.eq(position)))
                .where(enabledEq(Boolean.TRUE),
                        statusEq(status))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(studyArticles, pageable, studyArticles.size());
    }

    private BooleanExpression enabledEq(Boolean enabled){
        if (enabled == null) return null;
        return studyArticle.enabled.eq(enabled);
    }

    private BooleanExpression statusEq(StudyStatus status){
        if (status == null) return null;
        return studyArticle.studyInfo.status.eq(status);
    }

}
