package com.wayfarer.project.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wayfarer.project.dto.SkillParamDto;
import com.wayfarer.project.entity.ProjectArticle;
import com.wayfarer.project.entity.QProjectArticle;
import com.wayfarer.project.entity.enummodel.ProjectStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProjectArticleCustomRepositoryImpl implements ProjectArticleCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public ProjectArticleCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    QProjectArticle projectArticle = QProjectArticle.projectArticle;

    @Override
    public Page<ProjectArticle> getAll(Pageable pageable) {
        List<ProjectArticle> boardList = jpaQueryFactory.select(projectArticle)
                .from(projectArticle)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(boardList, pageable, boardList.size());
    }

    //enabled, pageinfo(모집여부), skill
    @Override
    public Page<ProjectArticle> getAllBySkill(ProjectStatus status, SkillParamDto skillParamDto, Pageable pageable) {
        List<ProjectArticle> boardList = jpaQueryFactory
                .select(projectArticle)
                .from(projectArticle)
                .where(
                        enabledEq(Boolean.TRUE),
                        statusEq(status),
                        skillContains(skillParamDto.getSkill1())
                                .or(skillContains(skillParamDto.getSkill2()))
                                .or(skillContains(skillParamDto.getSkill3()))
                                .or(skillContains(skillParamDto.getSkill4()))
                                .or(skillContains(skillParamDto.getSkill5()))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(boardList, pageable, boardList.size());
    }
// 테스트중
    /*private BooleanExpression query(String[] a){
        return enabledEq().and(statusEq()).or(skillContains());
    }*/

    private BooleanExpression enabledEq(Boolean enabled){
        if (enabled == null) return null;
        return projectArticle.enabled.eq(enabled);
    }

    private BooleanExpression statusEq(ProjectStatus status){
        if (status == null) return null;
        return projectArticle.projectInfo.status.eq(status);
    }

    private BooleanExpression skillContains(String skill) {
        if (skill == null) return null;
        return projectArticle.projectSkills.contains(skill);
    }
}
