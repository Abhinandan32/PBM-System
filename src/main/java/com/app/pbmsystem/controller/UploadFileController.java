package com.app.pbmsystem.controller;

import com.app.pbmsystem.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dawidbranicki on 13.04.2018.
 */

@RestController
public class UploadFileController {

    private UploadFileService uploadFileService;

    @Autowired
    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }
}
