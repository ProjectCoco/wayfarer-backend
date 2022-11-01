package com.wayfarer.study.helper;


import com.wayfarer.study.dto.StudyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

public class StudyStubData {
    public static List<StudyResponseDto> getAllStudyResponseDto() {
        StudyResponseDto.StudyArticle studyArticle1 = StudyResponseDto.StudyArticle.builder()
                .studyArticleId(1L)
                .title("여성 아티스트의 성장을 지원하는 NFT 프로젝트")
                .status("Not Deleted")
                .build();

        StudyResponseDto.StudyInfo studyInfo1 = StudyResponseDto.StudyInfo.builder()
                .purpose("purpose")
                .meetTime(null)
                .active("모집 중")
                .build();

        StudyResponseDto.StudyContent studyContent1 = StudyResponseDto.StudyContent.builder()
                .content("content")
                .version("v1")
                .build();

        LocalDateTime now = LocalDateTime.now();
        StudyResponseDto.StudyTime studyTime1 = StudyResponseDto.StudyTime.builder()
                .startTime(now)
                .deadline(now.plusDays(14))
                .build();

        StudyResponseDto studyResponseDto1 = new StudyResponseDto(studyArticle1, studyInfo1, studyContent1, studyTime1);

        StudyResponseDto.StudyArticle studyArticle2 = StudyResponseDto.StudyArticle.builder()
                .studyArticleId(1L)
                .title("축구팬 매칭 서비스 '풋렌들리' 팀원 모집합니다")
                .status("Not Deleted")
                .build();

        StudyResponseDto.StudyInfo studyInfo2 = StudyResponseDto.StudyInfo.builder()
                .purpose("purpose")
                .meetTime(null)
                .active("모집 중")
                .build();

        StudyResponseDto.StudyContent studyContent2 = StudyResponseDto.StudyContent.builder()
                .content("content")
                .version("v1")
                .build();

        StudyResponseDto.StudyTime studyTime2 = StudyResponseDto.StudyTime.builder()
                .startTime(now)
                .deadline(now.plusDays(14))
                .build();

        StudyResponseDto studyResponseDto2 = new StudyResponseDto(studyArticle2, studyInfo2, studyContent2, studyTime2);

        return List.of(studyResponseDto1, studyResponseDto2);
    }
}
