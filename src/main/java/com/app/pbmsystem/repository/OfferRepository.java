package com.app.pbmsystem.repository;

import com.app.pbmsystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Project, Long> {
}