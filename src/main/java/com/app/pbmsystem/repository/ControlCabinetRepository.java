package com.app.pbmsystem.repository;

import com.app.pbmsystem.model.ControlCabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlCabinetRepository extends JpaRepository<ControlCabinet, Long> {
}