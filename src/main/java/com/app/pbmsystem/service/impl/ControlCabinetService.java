package com.app.pbmsystem.service.impl;

import com.app.pbmsystem.dto.ControlCabinetDTO;
import com.app.pbmsystem.mapper.ControlCabinetMapper;
import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.repository.ControlCabinetRepository;
import com.app.pbmsystem.service.IControlCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dawidbranicki on 15.04.2018.
 */

@Service
public class ControlCabinetService implements IControlCabinetService {

    private ControlCabinetRepository controlCabinetRepository;

    private ControlCabinetMapper controlCabinetMapper;

    @Autowired
    public ControlCabinetService(ControlCabinetRepository controlCabinetRepository) {
        this.controlCabinetRepository = controlCabinetRepository;
    }

    @Override
    public List<ControlCabinet> controlCabinets() {
        List<ControlCabinet> controlCabinets = new ArrayList<>();
        controlCabinets.addAll(controlCabinetRepository.findAll());
        return controlCabinets;
    }

    @Override
    public void dropAll() {
        controlCabinetRepository.deleteAll();
    }

    @Override
    public void addCabinet(ControlCabinet controlCabinet) {
        controlCabinetRepository.save(controlCabinet);
    }

    @Override
    public void deleteById(Long id) {
        controlCabinetRepository.deleteById(id);
    }

    @Override
    public List<ControlCabinetDTO> getCabinetsForProject(Long id) {
        controlCabinetRepository.findAll().forEach(c -> controlCabinetMapper.CONTROL_CABINET_DTO(c));
        return controlCabinetRepository.findAll().stream().filter(c -> c.getProject_id().equals(id)).collect(Collectors.toList());
    }
}
