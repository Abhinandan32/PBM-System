package com.app.pbmsystem.service;

import com.app.pbmsystem.model.Offer;
import com.app.pbmsystem.repository.OfferRepository;

import com.app.pbmsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 15.04.2018.
 */
@Service
public class OfferService {

    private OfferRepository offerRepository;

    private UserRepository userRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    public List<Offer> offerList(){
        List<Offer> offers = new ArrayList<>();
        offers.addAll(offerRepository.findAll());
        return offers;
    }

    public void addOffer(Offer offer){
        offer.setOfferer(userRepository.findOneById(offer.getId()));
        offerRepository.save(offer);
    }

    public Optional<Offer> findOfferById(long id){
        return offerRepository.findById(id);
    }

}
