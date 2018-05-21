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
@Mapper(componentModel="spring")
@Component
public interface ControlCabinetMapper {

    @Mappings({
            @Mapping(target = "cabinetName", source = "entity.name"),
            @Mapping(target = "valuated", source = "entity.toValuation")
    })
    ControlCabinetDTO CONTROL_CABINET_DTO(ControlCabinet entity);


}
