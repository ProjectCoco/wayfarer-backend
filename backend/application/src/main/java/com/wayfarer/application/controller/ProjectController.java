package com.wayfarer.application.controller;


import com.wayfarer.project.dto.ProjectArticleRequestDto;
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
    public ResponseEntity readAllProject(@RequestParam int page,
                                         @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(projectService.readAllProjectArticles(page, status), HttpStatus.OK);
    }

    /*@GetMapping("/tag")
    public ResponseEntity readProjectWithTag(@RequestParam int page,
                                             @RequestParam(required = true) String tag,
                                             @RequestParam(defaultValue = "true") Boolean status) {
        return new ResponseEntity<>(projectService.readProjectArticlesWithTag(page, tag), HttpStatus.OK);
    }*/

    @GetMapping("/{projectId}")
    public ResponseEntity readStudy(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.readProjectArticle(projectId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createProject(@RequestBody ProjectArticleRequestDto projectAritcleRequestDto) {
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
