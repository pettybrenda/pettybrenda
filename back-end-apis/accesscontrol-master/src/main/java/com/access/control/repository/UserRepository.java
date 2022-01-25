package com.access.control.repository;

import com.access.control.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//tells spring that this is the interface to use for db management functions
@Repository
//JPA links interface to our db table.
public interface  UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    Optional<User> findByUsername(String userName);
//
//    Boolean existsByUsername(String userName);
//
//    Boolean existsByEmail(String email);
}

