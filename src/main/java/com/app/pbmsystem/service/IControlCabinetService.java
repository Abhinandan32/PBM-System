package com.app.pbmsystem.service;

import com.app.pbmsystem.model.ControlCabinet;

import java.util.List;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface IControlCabinetService {

    List<ControlCabinet> controlCabinets();

    void dropAll();

    void addCabinet(ControlCabinet controlCabinet);

    void deleteById(Long id);

    List<ControlCabinet> getCabinetsForProject(Long id);
}
