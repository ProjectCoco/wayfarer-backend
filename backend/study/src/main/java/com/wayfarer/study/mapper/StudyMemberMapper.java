package com.wayfarer.study.mapper;

import com.wayfarer.study.dto.StudyMemberDto;
import com.wayfarer.study.dto.StudyMemberResponseDto;
import com.wayfarer.study.entity.StudyMember;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyMemberMapper {

    StudyMember studyMemberDtoToStudyMember(StudyMemberDto studyMemberDto);

    List<StudyMemberResponseDto> studyMembersToStudyMemberResponseDtos(List<StudyMember> studyMembers);
}
