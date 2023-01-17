package com.wayfarer.project.mapper;

import com.wayfarer.project.dto.ProjectMemberDto;
import com.wayfarer.project.dto.ProjectMemberResponseDto;
import com.wayfarer.project.entity.ProjectMember;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    ProjectMember projectMemberDtoToProjectMember(ProjectMemberDto projectMemberDto);

    List<ProjectMemberResponseDto> projectMembersToProjectMemberResponseDtos(List<ProjectMember> projectMembers);

    ProjectMemberResponseDto projectMemberToProjectMemberResponseDto(ProjectMember projectMember);
}
