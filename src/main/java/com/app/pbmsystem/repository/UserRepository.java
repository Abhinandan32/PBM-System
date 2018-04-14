package com.app.pbmsystem.repository;

import com.app.pbmsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByFirstNameAndLastName(String firstName, String lastName);

    User getById(long id);
}