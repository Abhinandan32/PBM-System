package com.app.pbmsystem.service.impl;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.mapper.ProjectMapper;
import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.repository.ProjectRepository;

import com.app.pbmsystem.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dawidbranicki on 15.04.2018.
 */
@Service
public class ProjectService implements IProjectService {

    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> projectsList() {
        List<Project> projects = new ArrayList<>();
        projects.addAll(projectRepository.findAll());
        return projects;
    }

    @Override
    public Optional<Project> findProjectById(long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectDTO> projectListDTO() {
        return projectsList().stream()
                .map(entity -> projectMapper.PROJECT_DTO(entity))
                .collect(Collectors.toList());
    }
}
