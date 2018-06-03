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
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dawidbranicki on 15.04.2018.
 */

@Service
public class ControlCabinetService implements IControlCabinetService {

    private ControlCabinetRepository controlCabinetRepository;

    private ControlCabinetMapper controlCabinetMapper;

    @Autowired
    public ControlCabinetService(ControlCabinetRepository controlCabinetRepository, ControlCabinetMapper controlCabinetMapper) {
        this.controlCabinetRepository = controlCabinetRepository;
        this.controlCabinetMapper = controlCabinetMapper;
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
    public void addCabinet(ControlCabinetDTO controlCabinetDTO) {
        controlCabinetRepository.save(controlCabinetMapper.CONTROL_CABINET(controlCabinetDTO));
    }

    @Override
    public void editCabinet(ControlCabinetDTO controlCabinetDTO) {
        controlCabinetRepository.save(controlCabinetMapper.CONTROL_CABINET(controlCabinetDTO));
    }

    @Override
    public void deleteById(Long id) {
        controlCabinetRepository.deleteById(id);
    }

    @Override
    public Optional<ControlCabinet> isExist(Long id) {
        return controlCabinetRepository.findById(id);
    }

    @Override
    public List<ControlCabinetDTO> getCabinetsForProject(Long id) {
        return controlCabinetRepository.findAll().stream().filter(c -> c.getProject_id().equals(id))
                .map(entity -> controlCabinetMapper.CONTROL_CABINET_DTO_BASIC_INFO(entity)).collect(Collectors.toList());
    }
}
