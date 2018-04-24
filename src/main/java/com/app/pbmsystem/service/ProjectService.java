package com.app.pbmsystem.service;

import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 15.04.2018.
 */
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> projectsList(){
        List<Project> projects = new ArrayList<>();
        projects.addAll(projectRepository.findAll());
        return projects;
    }

    public Optional<Project> findOfferById(long id){
        return projectRepository.findById(id);
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
