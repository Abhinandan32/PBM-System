package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.ControlCabinet;
import com.app.pbmsystem.service.IControlCabinetService;
import com.app.pbmsystem.service.impl.ControlCabinetService;
import com.app.pbmsystem.service.impl.CsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by dawidbranicki on 14.04.2018.
 */
@RestController
@RequestMapping(value = "/cabinet")
public class ControlCabinetController {

    private IControlCabinetService controlCabinetService;
    private CsvFileService csvFileService;

    @Autowired
    public ControlCabinetController(IControlCabinetService controlCabinetService, CsvFileService csvFileService) {
        this.controlCabinetService = controlCabinetService;
        this.csvFileService = csvFileService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<ControlCabinet>> getAllControlCabinets() {
        List<ControlCabinet> controlCabinets = controlCabinetService.controlCabinets();

        return new ResponseEntity<>(controlCabinets, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllData() {
        List<ControlCabinet> controlCabinets = controlCabinetService.controlCabinets();
        if (controlCabinets.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        controlCabinetService.dropAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addCabinet(@RequestBody ControlCabinet controlCabinet) {
        controlCabinetService.addCabinet(controlCabinet);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCabinet(@PathVariable Long id) {
        controlCabinetService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> loadFile(@RequestPart MultipartFile file) {
        String msg;
        try {
            csvFileService.store(file);
            msg = "You successfully uploaded " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        } catch (Exception e) {
            msg = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(msg);
        }
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ControlCabinet>> getCabinetsForProjectId(@PathVariable Long id){
        List<ControlCabinet> controlCabinets = controlCabinetService.getCabinetsForProject(id);
        if (controlCabinets.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(controlCabinets, HttpStatus.OK);
    }
}
