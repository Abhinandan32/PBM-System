package com.app.pbmsystem.mapper;

import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.model.ControlCabinet;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

/**
 * Created by dawidbranicki on 21.05.2018.
 */
public class ControlCabinetMapperTest {

    private final ControlCabinetMapper controlCabinetMapper = Mappers.getMapper(ControlCabinetMapper.class);
    private static final String CABINET_NAME = "szafa";
    private static final boolean VALUATION = true;

    @Test
    public void ControlCabinetEntityToControlCabinetDTOTest(){
        ControlCabinet entity = new ControlCabinet();
        entity.setId((long) 1);
        entity.setName(CABINET_NAME);
        entity.setToValuation(VALUATION);

        ControlCabinetDTO dto = controlCabinetMapper.CONTROL_CABINET_DTO(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getCabinetName(), entity.getName());
        assertEquals(dto.isValuated(), entity.isToValuation());
    }

}