package com.app.pbmsystem.controller;

import com.app.pbmsystem.service.CsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
}
