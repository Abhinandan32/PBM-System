package com.app.pbmsystem.controller;

import com.app.pbmsystem.service.CsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dawidbranicki on 13.04.2018.
 */

@RestController
public class CsvFileController {

    private CsvFileService csvFileService;

    @Autowired
    public CsvFileController(CsvFileService csvFileService) {
        this.csvFileService = csvFileService;
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
}
