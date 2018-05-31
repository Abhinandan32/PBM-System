package com.app.pbmsystem.service;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.model.Project;

import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface IProjectService {
    List<Project> projectsList();

    Optional<Project> findProjectById(long id);

    void addProject(Project project);

    void deleteById(Long id);

    List<ProjectDTO> projectListDTO();

}
