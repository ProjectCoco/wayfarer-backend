package com.wayfarer.application.controller;


import com.wayfarer.common.dto.MultiResponseDto;
import com.wayfarer.project.dto.*;
import com.wayfarer.project.entity.enummodel.ProjectStatus;
import com.wayfarer.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("")
    //todo page
    public ResponseEntity<MultiResponseDto<ProjectArticleResponseDto>> readAllProject(@RequestParam int page,
                                                                                      @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(projectService.readAllProjectArticles(page, status), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<MultiResponseDto<ProjectArticleResponseDto>> readProjectWithTag(@RequestParam int page,
                                                                                          @RequestParam(required = true) String tag,
                                                                                          @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(projectService.readProjectArticlesWithTag(page, tag, status), HttpStatus.OK);
    }

    @GetMapping("/skill")
    public ResponseEntity<MultiResponseDto<ProjectArticleResponseDto>> readProjectWithSkill(@RequestParam int page,
                                                                                            @ModelAttribute SkillParamDto skills,
                                                                                            @RequestParam(required = false) ProjectStatus status) {
        return new ResponseEntity<>(projectService.readProjectArticlesWithSkills(page, skills, status), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectArticleDetailResponseDto> readProject(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.readProjectArticle(projectId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createProject(@RequestBody ProjectArticleRequestDto projectAritcleRequestDto) {
        projectService.createProjectArticle(projectAritcleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> putProject(@PathVariable Long projectId,
                                           @RequestBody ProjectArticlePutRequestDto projectArticlePutRequestDto) {
        projectService.updateProjectArticle(projectId, projectArticlePutRequestDto);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }


    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        //delete -> status 변경
        projectService.deleteProjectArticle(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/popular")
    //todo: 찜 기능 추가시 로직 개선
    public ResponseEntity<MultiResponseDto<ProjectArticleResponseDto>> popularAllProjects() {
        return new ResponseEntity<>(projectService.readAllPopularProjectArticles(), HttpStatus.OK);
    }
}
