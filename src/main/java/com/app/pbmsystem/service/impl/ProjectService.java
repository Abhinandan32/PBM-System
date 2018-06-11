package com.app.pbmsystem.service.impl;

import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.mapper.ProjectMapper;
import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.repository.ControlCabinetRepository;
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
    private ControlCabinetRepository controlCabinetRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper, ControlCabinetRepository controlCabinetRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.controlCabinetRepository = controlCabinetRepository;
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

    @Override
    public boolean isExist(Long id) {
        return projectRepository.findById(id).isPresent();
    }

    @Override
    public void editProject(Project project) {
        List<ControlCabinet> controlCabinets = controlCabinetRepository.findAll()
                .stream().filter(c -> c.getProject_id().equals(project.getId()))
                .collect(Collectors.toList());

        project.setControlCabinets(controlCabinets);
        projectRepository.save(project);
    }

}
