package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.Project;
import com.app.pbmsystem.service.OfferService;
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
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value = "/offers", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getOffers() {
        List<Project> projects = offerService.offerList();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }


}
