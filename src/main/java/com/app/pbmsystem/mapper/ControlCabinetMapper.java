package com.app.pbmsystem.mapper;

import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.model.ControlCabinet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

/**
 * Created by dawidbranicki on 21.05.2018.
 */
@Mapper(componentModel = "spring")
@Component
public interface ControlCabinetMapper {

    @Mappings({
            @Mapping(target = "cabinetName", source = "entity.name"),
            @Mapping(target = "valuated", source = "entity.toValuation"),
            @Mapping(target = "adjustedCost", ignore = true),
            @Mapping(target = "contactorsAmount", ignore = true),
            @Mapping(target = "current", ignore = true),
            @Mapping(target = "archive", ignore = true),
            @Mapping(target = "notUsedInModel", ignore = true),
            @Mapping(target = "plcInput", ignore = true),
            @Mapping(target = "plcOutput", ignore = true),
            @Mapping(target = "project_id", ignore = true),
            @Mapping(target = "realTime", ignore = true),
            @Mapping(target = "protectionAmount", ignore = true),
            @Mapping(target = "safety", ignore = true),
            @Mapping(target = "driveAmount", ignore = true)
    })
    ControlCabinetDTO CONTROL_CABINET_DTO_BASIC_INFO(ControlCabinet entity);

    @Mappings({
            @Mapping(target = "name", source = "dto.cabinetName"),
            @Mapping(target = "toValuation", source = "dto.valuated")
    })
    ControlCabinet CONTROL_CABINET(ControlCabinetDTO dto);
}
