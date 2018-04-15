package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.Offer;
import com.app.pbmsystem.service.OfferService;
import com.app.pbmsystem.service.UserService;
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
    public ResponseEntity<List<Offer>> getOffers() {
        List<Offer> offers = offerService.offerList();
        if (offers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }


}
