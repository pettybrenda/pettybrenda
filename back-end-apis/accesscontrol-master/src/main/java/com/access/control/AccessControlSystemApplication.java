package com.access.control;

import com.access.control.models.Roles;
import com.access.control.models.User;
import com.access.control.service.RolesService;
import com.access.control.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan(basePackages = {"com.access.control.*", "com.access.control.config"})
@EntityScan()
//@EnableJpaRepositories("com.access.control.repository")
@EnableJpaRepositories(basePackages = "com.access.control.repository", entityManagerFactoryRef = "entityManagerFactory")
public class AccessControlSystemApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessControlSystemApplication.class);
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {

        SpringApplication.run(AccessControlSystemApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void initAdmin() {
        log.debug("Application has started ---------------------------");
        System.out.println("----------------------------------------------");
        registerAdminAuto();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;


    private void registerAdminAuto() {
        if (rolesService.checkRoleExistence("Admin")) {
            System.out.println("Admin already exist! ");
        } else {
            Roles role = new Roles();
            role.setName("Admin");
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add("all");
            role.setPermissions(permissions);

            User user = new User();
            user.setUserName("Admin");
            user.setPassword("root");
            user.setEmail("admin@example.com");
            user.setRole(role);
            rolesService.save(role);
            userService.save(user);
            log.debug("Saved ---- "+user.toString());

        }


    }

}
