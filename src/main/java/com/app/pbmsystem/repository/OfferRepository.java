package com.app.pbmsystem.repository;

import com.app.pbmsystem.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}