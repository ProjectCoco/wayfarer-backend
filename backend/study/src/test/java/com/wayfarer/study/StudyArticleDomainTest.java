package com.wayfarer.study;

import com.wayfarer.study.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StudyArticleDomainTest {

    @DisplayName("STUDY_ARTICLE 엔터티 테스트")
    @Test
    void studyArticleTest() {
        long studyArticleId = 1L;
        String title = "title";
        String contentVersion = "contentVersion";
        String status = "status";

        StudyArticle studyArticle = StudyArticle.builder()
                .studyArticleId(studyArticleId)
                .title(title)
                .contentVersion(contentVersion)
                .status(status)
                .build();

        assertThat(studyArticle.getStudyArticleId(), is(studyArticleId));
        assertThat(studyArticle.getTitle(), is(title));
        assertThat(studyArticle.getContentVersion(), is(contentVersion));
        assertThat(studyArticle.getStatus(), is(status));
    }

    @DisplayName("STUDY_CONTENT 엔터티 테스트")
    @Test
    void studyContentTest() {
        long studyContentId = 1L;
        String content = "content";
        String version = "version";
        long studyArticleId = 1L;

        StudyContent studyContent = StudyContent.builder()
                .studyContentId(studyContentId)
                .content(content)
                .version(version)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyContent.getStudyContentId(), is(studyContentId));
        assertThat(studyContent.getContent(), is(content));
        assertThat(studyContent.getVersion(), is(version));
        assertThat(studyContent.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_INFO 엔터티 테스트")
    @Test
    void studyInfoTest() {
        long studyInfoId = 1L;
        String purpose = "purpose";
        LocalDateTime meetTime = LocalDateTime.now();
        String active = "active";
        long studyArticleId = 1L;

        StudyInfo studyInfo = StudyInfo.builder()
                .studyInfoId(studyInfoId)
                .purpose(purpose)
                .meetTime(meetTime)
                .active(active)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyInfo.getStudyInfoId(), is(studyInfoId));
        assertThat(studyInfo.getPurpose(), is(purpose));
        assertThat(studyInfo.getMeetTime(), is(meetTime));
        assertThat(studyInfo.getActive(), is(active));
        assertThat(studyInfo.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_TIME 엔터티 테스트")
    @Test
    void studyTimeTest() {
        long studyTimeId = 1L;
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime deadline = LocalDateTime.now();
        long studyArticleId = 1L;

        StudyTime studyTime = StudyTime.builder()
                .studyTimeId(studyTimeId)
                .startTime(startTime)
                .deadline(deadline)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyTime.getStudyTimeId(), is(studyTimeId));
        assertThat(studyTime.getStartTime(), is(startTime));
        assertThat(studyTime.getDeadline(), is(deadline));
        assertThat(studyTime.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_SKILL 엔터티 테스트")
    @Test
    void studySkillTest() {
        long studySkillId = 1L;
        long skillId = 1L;
        long studyArticleId = 1L;

        StudySkill studySkill = StudySkill.builder()
                .studySkillId(studySkillId)
                .skillId(skillId)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studySkill.getStudySkillId(), is(studySkillId));
        assertThat(studySkill.getSkillId(), is(skillId));
        assertThat(studySkill.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_MEMBER 엔터티 테스트")
    @Test
    void studyMemberTest() {
        long studyMemberId = 1L;
        String studyRole = "studyRole";
        int memberCount = 1;
        int memberGoalCount = 1;
        long studyArticleId = 1L;

        StudyMember studyMember = StudyMember.builder()
                .studyMemberId(studyMemberId)
                .studyRole(studyRole)
                .memberCount(memberCount)
                .memberGoalCount(memberGoalCount)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyMember.getStudyMemberId(), is(studyMemberId));
        assertThat(studyMember.getStudyRole(), is(studyRole));
        assertThat(studyMember.getMemberCount(), is(memberCount));
        assertThat(studyMember.getMemberGoalCount(), is(memberGoalCount));
        assertThat(studyMember.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_OWNER 엔터티 테스트")
    @Test
    void studyOwnerTest() {
        long studyOwnerId = 1L;
        long ownerId = 1L;
        long studyArticleId = 1L;

        StudyOwner studyOwner = StudyOwner.builder()
                .studyOwnerId(studyOwnerId)
                .ownerId(ownerId)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyOwner.getStudyOwnerId(), is(studyOwnerId));
        assertThat(studyOwner.getOwnerId(), is(ownerId));
        assertThat(studyOwner.getStudyArticleId(), is(studyArticleId));
    }

    @DisplayName("STUDY_TAG 엔터티 테스트")
    @Test
    void studyTagTest() {
        long studyTagId = 1L;
        long tagId = 1L;
        long studyArticleId = 1L;

        StudyTag studyTag = StudyTag.builder()
                .studyTagId(studyTagId)
                .tagId(tagId)
                .studyArticleId(studyArticleId)
                .build();

        assertThat(studyTag.getStudyTagId(), is(studyTagId));
        assertThat(studyTag.getTagId(), is(tagId));
        assertThat(studyTag.getStudyArticleId(), is(studyArticleId));
    }


}
