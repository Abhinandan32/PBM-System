package com.app.pbmsystem.mapper;

import com.app.pbmsystem.dto.ProjectDTO;
import com.app.pbmsystem.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * Created by dawidbranicki on 31.05.2018.
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper {


    @Mapping(target ="projectName" , source ="entity.name" )
    ProjectDTO PROJECT_DTO(Project entity);
}
