package com.app.pbmsystem.service;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.model.Project;

import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface ProjectService {
    List<Project> projectsList();

    Optional<Project> findProjectById(long id);

    void addProject(Project project);

    void deleteById(Long id);

    List<ProjectDTO> projectListDTO();

    boolean isExist(Long id);

    void editProject(Project project);
}
