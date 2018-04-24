package com.app.pbmsystem.service;

import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.repository.ControlCabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawidbranicki on 15.04.2018.
 */

@Service
public class ControlCabinetService {

    private ControlCabinetRepository controlCabinetRepository;

    @Autowired
    public ControlCabinetService(ControlCabinetRepository controlCabinetRepository) {
        this.controlCabinetRepository = controlCabinetRepository;
    }

    public List<ControlCabinet> controlCabinets(){
        List<ControlCabinet> controlCabinets = new ArrayList<>();
        controlCabinets.addAll(controlCabinetRepository.findAll());
        return controlCabinets;
    }

    public void dropAll(){
        controlCabinetRepository.deleteAll();
    }

    public void addCabinet(ControlCabinet controlCabinet){
        controlCabinetRepository.save(controlCabinet);
    }

    public void deleteById(Long id){
        controlCabinetRepository.deleteById(id);
    }
}
