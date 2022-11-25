package com.wayfarer.study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//@DataJpaTest
//class StudyArticleDomainTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @TestFactory
//    Stream<DynamicTest> studyArticleNullException() {
//        List<StudyArticle> articles = List.of(
//                StudyArticle.builder()
//                        .status("status")
//                        .build(),
//                StudyArticle.builder()
//                        .title("title")
//                        .build()
//        );

//        return articles.stream()
//                .map(article -> DynamicTest.dynamicTest(
//                        "STUDY_ARTICLE null exception 테스트",
//                        () -> {
//                            assertThatThrownBy(() -> entityManager.persist(article)).isInstanceOf(PersistenceException.class);
//                        }
//                ));
//    }

//    @DisplayName("STUDY_ARTICLE 엔터티 테스트")
//    @Test
//    void saveStudyArticle() {
//        String title = "title";
//        String status = "status";

//        StudyArticle studyArticle = StudyArticle.builder()
//                .title(title)
//                .status(status)
//                .build();

//        StudyArticle savedStudyArticle = entityManager.persistFlushFind(studyArticle);
//
//        assertThat(savedStudyArticle.getTitle(), is(title));
//        assertThat(savedStudyArticle.getStatus(), is(status));
//    }

/*    @DisplayName("STUDY_CONTENT 엔터티 테스트")
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
    }*/


//}
