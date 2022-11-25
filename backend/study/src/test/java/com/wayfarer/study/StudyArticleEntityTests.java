package com.wayfarer.study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("StudyArticle Entity Tests")
public class StudyArticleEntityTests {

/*    @Autowired
    private TestEntityManager testEntityManager;

    private StudyArticle studyArticle;
    private StudyArticle studyArticleWithoutTitle;
    private StudyArticle studyArticleWithoutStatus;


    @BeforeEach
    public void setup() {
//        studyArticle = StudyArticle.builder()
//                .title("title")
//                .status("status")
//                .build();
//        studyArticleWithoutTitle = StudyArticle.builder()
//                .status("status")
//                .build();
//        studyArticleWithoutStatus = StudyArticle.builder()
//                .title("title")
//                .build();
    }

    @Nested
    @DisplayName("Success Case")
    public class SuccessCase {

        @Test
        @DisplayName("엔티티가 생성되는지 테스트한다.")
        public void saveEntity() {
//            StudyArticle saveStudyArticle = testEntityManager.persistFlushFind(studyArticle);
//
//            assertThat(saveStudyArticle.getTitle(), equalTo(studyArticle.getTitle()));
//            assertThat(saveStudyArticle.getStatus(), equalTo(studyArticle.getStatus()));
        }
    }

    @Nested
    @DisplayName("Failure Case")
    public class FailureCase {

        @Test
        @DisplayName("엔터티의 Title 필드가 null일때 Exception이 발생한다.")
        public void saveEntityNullTitleException() {
            assertThatThrownBy(() -> testEntityManager.persist(studyArticleWithoutTitle)).isInstanceOf(PersistenceException.class);
        }

        @Test
        @DisplayName("엔터티의 Status 필드가 null일때 Exception이 발생한다.")
        public void saveEntityNullStatusException() {
            assertThatThrownBy(() -> testEntityManager.persist(studyArticleWithoutStatus)).isInstanceOf(PersistenceException.class);
        }

    }*/
}
