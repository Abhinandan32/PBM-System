package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 14.04.2018.
 */

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.projectsList();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Project> deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getProject(@PathVariable Long id) {
        projectService.findOfferById(id);
        Optional<Project> project = projectService.findOfferById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
