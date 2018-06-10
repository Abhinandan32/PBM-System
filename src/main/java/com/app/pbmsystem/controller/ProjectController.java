package com.app.pbmsystem.controller;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "PMB System", description = "All operation for projects", tags = "Project")
public class ProjectController {

    private IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }


    @ApiOperation(value = "View a list of available projects", response = ResponseEntity.class)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.projectsList();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available projects names", response = ResponseEntity.class)
    @RequestMapping(value = "/get/names", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectDTO>> getProjectsNames() {
        List<ProjectDTO> projects = projectService.projectListDTO();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @ApiOperation(value = "Add new project")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete single project by using id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Project> deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Get single project by using id")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getProject(@PathVariable Long id) {
        projectService.findProjectById(id);
        Optional<Project> project = projectService.findProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
