package com.wayfarer.application.controller;


import com.wayfarer.study.dto.StudyArticleUpdateRequestDto;
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
    public ResponseEntity readAllProject(@RequestParam int page) {
        return new ResponseEntity<>(projectService.readAllProjectArticles(page), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity readProjectWithTag(@RequestParam int page, String tag) {
        return new ResponseEntity<>(projectService.readProjectArticlesWithTag(page, tag), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity readStudy(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.readProjectAritcle(projectId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createProject(@RequestBody ProjectAritcleRequestDto projectAritcleRequestDto) {
        projectService.createProjectArticle(projectAritcleRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }




    @DeleteMapping("/{projectId}")
    public ResponseEntity deleteProject(@PathVariable Long projectId) {
        //delete -> status 변경
        projectService.deleteProjectArticle(projectId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
