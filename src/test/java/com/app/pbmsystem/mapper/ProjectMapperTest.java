package com.app.pbmsystem.mapper;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.model.Project;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

/**
 * Created by dawidbranicki on 31.05.2018.
 */
public class ProjectMapperTest {

    private ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    @Test
    public void ProjectEntityToProjectDTOMapperTest(){
        Project entity = new Project();
        entity.setId((long) 12);
        entity.setName("Testowy projekt");

        ProjectDTO dto = projectMapper.PROJECT_DTO(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getProjectName(), entity.getName());
    }

}