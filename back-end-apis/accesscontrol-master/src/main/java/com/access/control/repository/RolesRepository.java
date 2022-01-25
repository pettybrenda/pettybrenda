package com.access.control.repository;

import com.access.control.models.ERole;
import com.access.control.models.Roles;
import com.access.control.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface  RolesRepository extends JpaRepository<Roles, Long> {
//    Roles findRolesByName(String name);
    Optional<Roles>findByName(ERole name);


}
