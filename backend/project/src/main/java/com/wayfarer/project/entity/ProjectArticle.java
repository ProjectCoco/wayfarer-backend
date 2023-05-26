package com.wayfarer.project.entity;

import com.wayfarer.common.audit.Auditable;
import com.wayfarer.project.dto.ProjectArticlePutRequestDto;
import com.wayfarer.project.entity.converter.BooleanToYNConverter;
import com.wayfarer.project.entity.enummodel.ProjectSkillEnum;
import com.wayfarer.project.entity.enummodel.ProjectStatus;
import com.wayfarer.project.entity.vo.ProjectContent;
import com.wayfarer.project.entity.vo.ProjectInfo;
import com.wayfarer.project.entity.vo.ProjectTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectArticle extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectArticleId;

    @Column(nullable = false, length = 30)
    private String title;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private String projectTags;

    @Column(nullable = false)
    private String projectMembers;

    @Embedded
    private ProjectContent projectContent;

    @Embedded
    private ProjectTime projectTime;

    @Embedded
    private ProjectInfo projectInfo;

    @Embedded
    private ProjectOwner projectOwner;

    @Column(nullable = false)
    private String projectSkills;

    public void initProjectArticle() {
        this.enabled = true;
        this.projectInfo = new ProjectInfo(ProjectStatus.PROCEED);
    }

    public void changeEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void updateAll(ProjectArticlePutRequestDto projectArticlePutRequestDto) {
        this.title = projectArticlePutRequestDto.getTitle();
        this.projectContent.setContent(projectArticlePutRequestDto.getProjectContent());
        this.projectTime.setStartTime(projectArticlePutRequestDto.getStartTime());
        setProjectTags(projectArticlePutRequestDto.getProjectTags());
        setProjectSkills(projectArticlePutRequestDto.getProjectSkills());
    }

    public List<String> getProjectTags(){
        List<String> strings = new ArrayList<>();
        if (this.projectTags != null) {
            strings = Arrays.asList(this.projectTags.split(","));
        }
        return strings;
    }

    public List<String> getProjectSkills(){
        List<String> strings = new ArrayList<>();
        if (this.projectSkills != null) {
            strings = Arrays.asList(this.projectSkills.split(","));
        }
        return strings;
    }

    public void setProjectTags(List<String> tags){
        this.projectTags = String.join(",", tags);
    }

    public void setProjectSkills(List<ProjectSkillEnum> skills){
        this.projectSkills = skills.stream().map(ProjectSkillEnum::getValue).collect(Collectors.joining(","));
    }

    public List<String> getProjectMembers(){
        List<String> strings = new ArrayList<>();
        if (this.projectMembers != null) {
            strings = Arrays.asList(this.projectMembers.split(","));
        }
        return strings;
    }

    public void setProjectMembers(List<String> projectMembers){
        this.projectMembers = String.join(",", projectMembers);
    }

}
