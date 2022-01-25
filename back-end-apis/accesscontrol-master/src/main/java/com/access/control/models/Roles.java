package com.access.control.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @lombok.Setter
    @lombok.Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public ERole name;

    public Roles() {
    }

    public Roles(ERole name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    private String name;//admin, supervisor or regular officer.
//    @ElementCollection
//    @Column
//    @CollectionTable(name = "permissions", joinColumns = @JoinColumn(name = "id"))
//    private List<String>  permissions;
//    private long userId;
//    @OneToMany(targetEntity = User.class)
//    List<User> users=new ArrayList<User>();
//
//
//    public Roles(String name, List<String> permissions) {
//        this.name = name;
//
//        this.permissions = permissions;
//    }
//
//    public Roles() {
//
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setPermissions(List<String> permissions) {
//        this.permissions = permissions;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}


