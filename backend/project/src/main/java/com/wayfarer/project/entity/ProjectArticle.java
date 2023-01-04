package com.wayfarer.project.entity;

import com.wayfarer.project.dto.ProjectArticleUpdateRequestDto;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProjectArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long projectArticleId;

    @Column()
    private String title;

    @Convert(converter = BooleanToYNConverter.class)
    private Boolean enabled;

    @Column
    private String projectTags;

    @Column
    @CreatedDate
    private LocalDateTime createdTime; // null

    @Column
    private String projectMembers;

    @Embedded
    private ProjectContent projectContent;

    @Embedded
    private ProjectTime projectTime;

    @Embedded
    private ProjectInfo projectInfo;

    @Embedded
    private ProjectOwner projectOwner;

    @Column
    private String projectSkills;

    public void initProjectArticle() {
        this.enabled = true;
        this.projectInfo = new ProjectInfo(ProjectStatus.PROCEED);
    }

    public void changeEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void updateAll(ProjectArticleUpdateRequestDto projectArticleUpdateRequestDto) {
        this.title = projectArticleUpdateRequestDto.getTitle();
        this.projectTags = projectArticleUpdateRequestDto.getProjectTags();
        this.projectMember.setTotalMember(projectArticleUpdateRequestDto.getProjectTotalMember());
        this.projectContent.setContent(projectArticleUpdateRequestDto.getProjectContent());
        this.projectTime.setStartTime(projectArticleUpdateRequestDto.getStartTime());
        this.projectSkills = projectArticleUpdateRequestDto.getProjectSkills();
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
