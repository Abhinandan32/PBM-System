package com.app.pbmsystem.service;

import com.app.pbmsystem.model.Project;
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
public class ProjectService {

    private OfferRepository offerRepository;

    private UserRepository userRepository;

    @Autowired
    public ProjectService(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    public List<Project> offerList(){
        List<Project> projects = new ArrayList<>();
        projects.addAll(offerRepository.findAll());
        return projects;
    }

//    public void addOffer(Project project){
//        project.setOfferer(userRepository.findOneById(project.getId()));
//        offerRepository.save(project);
//    }

    public Optional<Project> findOfferById(long id){
        return offerRepository.findById(id);
    }

}
