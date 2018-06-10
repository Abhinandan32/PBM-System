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
    public void ControlCabinetEntityToControlCabinetDTOBasicTest() {
        ControlCabinet entity = new ControlCabinet();

        entity.setId((long) 1);
        entity.setName(CABINET_NAME);
        entity.setToValuation(VALUATION);

        ControlCabinetDTO dto = controlCabinetMapper.CONTROL_CABINET_DTO_BASIC_INFO(entity);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.isToValuation(), entity.isToValuation());
    }

    @Test
    public void ControlCabinetEntityToControlCabinetDTOAddingTest() {
        ControlCabinetDTO dto = new ControlCabinetDTO();
        //given
        dto.setId((long) 1);
        dto.setToValuation(true);
        dto.setName("test");
        dto.setNotUsedInModel(true);
        dto.setArchive(true);
        dto.setAdjustedCost((long) 31121);
        dto.setContactorsAmount((long) 21);
        dto.setCurrent((long) 21);
        dto.setRealTime((long) 1);
        dto.setDriveAmount((long) 2112);
        dto.setPlcInput((long) 2231);
        dto.setPlcOutput((long) 21);
        dto.setSafety((long) 321);
        dto.setDriveAmount((long) 12);

        ControlCabinet entity = controlCabinetMapper.CONTROL_CABINET(dto);
        //when
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.isToValuation(), dto.isToValuation());
        assertEquals(entity.getAdjustedCost(), dto.getAdjustedCost());
        assertEquals(entity.getContactorsAmount(), dto.getContactorsAmount());
        assertEquals(entity.getCurrent(), dto.getCurrent());
        assertEquals(entity.getPlcInput(), dto.getPlcInput());
        assertEquals(entity.getPlcOutput(), dto.getPlcOutput());
        assertEquals(entity.getProject_id(), dto.getProject_id());
        assertEquals(entity.getProtectionAmount(), dto.getProtectionAmount());
        assertEquals(entity.getRealTime(), dto.getRealTime());
        assertEquals(entity.getSafety(), dto.getSafety());
        assertEquals(entity.isNotUsedInModel(), dto.isNotUsedInModel());
        assertEquals(entity.isArchive(), dto.isArchive());
        assertEquals(entity.getDriveAmount(), dto.getDriveAmount());
    }
}