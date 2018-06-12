package com.app.pbmsystem.service;

import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.model.ControlCabinet;

import java.util.List;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface ControlCabinetService {

    List<ControlCabinet> controlCabinets();

    void dropAll();

    void addCabinet(ControlCabinet controlCabinet);

    void addCabinet(ControlCabinetDTO controlCabinetDTO);

    void editCabinet(ControlCabinetDTO controlCabinetDTO);

    void deleteById(Long id);

    boolean isExist(Long id);

    List<ControlCabinetDTO> getCabinetsForProject(Long id);
}
