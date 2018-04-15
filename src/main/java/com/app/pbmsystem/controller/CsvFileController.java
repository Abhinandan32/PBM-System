package com.app.pbmsystem.controller;

import com.app.pbmsystem.service.CsvFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.LogManager;


/**
 * Created by dawidbranicki on 13.04.2018.
 */

@RestController
public class CsvFileController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private CsvFileService csvFileService;

    @Autowired
    public CsvFileController(CsvFileService csvFileService) {
        this.csvFileService = csvFileService;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity loadFile(@RequestParam("file") MultipartFile file) {
        logger.debug("Dodano plik");
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
