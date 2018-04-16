package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.service.ControlCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dawidbranicki on 14.04.2018.
 */
@RestController
public class ControlCabinetController {

    private ControlCabinetService controlCabinetService;

    @Autowired
    public ControlCabinetController(ControlCabinetService controlCabinetService) {
        this.controlCabinetService = controlCabinetService;
    }

    @RequestMapping(value = "/cabinets", method = RequestMethod.GET)
    public ResponseEntity<List<ControlCabinet>> getAllControlCabinets(){
        List<ControlCabinet> controlCabinets = controlCabinetService.controlCabinets();

        return new ResponseEntity<>(controlCabinets, HttpStatus.OK);
    }
}
