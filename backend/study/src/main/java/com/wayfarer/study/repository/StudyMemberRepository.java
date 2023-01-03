package com.wayfarer.study.repository;

import com.wayfarer.study.entity.StudyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyMemberRepository extends JpaRepository<StudyMember, Long> {

     List<StudyMember> findByStudyArticleId(Long studyArticleId);

}
