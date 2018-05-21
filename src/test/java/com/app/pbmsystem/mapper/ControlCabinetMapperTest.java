package com.app.pbmsystem.mapper;

import com.app.pbmsystem.PbmSystemApplicationTests;
import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.model.ControlCabinet;
import org.junit.jupiter.api.*;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dawidbranicki on 21.05.2018.
 */


class ControlCabinetMapperTest extends PbmSystemApplicationTests{

    @Autowired
    @Spy
    private ControlCabinetMapper mapper;

    @Test
    public void givenControlCabinetDTO(){
        ControlCabinet enitity = new ControlCabinet();
        enitity.setId(1L);
        enitity.setName("szafka");
        enitity.setToValuation(true);

        ControlCabinetDTO dto = mapper.CONTROL_CABINET_DTO(enitity);

        assertEquals(dto.getId(), enitity.getId());
        assertEquals(dto.getCabinetName(), enitity.getName());
        assertEquals(dto.isValuated(), enitity.isToValuation());

    }

}