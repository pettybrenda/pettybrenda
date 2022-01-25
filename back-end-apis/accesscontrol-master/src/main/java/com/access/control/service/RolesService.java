package com.access.control.service;

import com.access.control.models.Roles;
import com.access.control.models.User;
import com.access.control.repository.RolesRepository;
import com.access.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;

@Service

public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;


    public Roles save(Roles roles){
        return rolesRepository.save(roles);
    }
    @Transactional(readOnly = true)
    public Roles findRolesByName(String  name) {
        return rolesRepository.findRolesByName(name);
    }
    public boolean checkRoleExistence(String name){
        return findRolesByName(name)==null?false:true;
    }


}
