package com.app.pbmsystem.repository;

import com.app.pbmsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}