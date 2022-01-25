package com.access.control.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
public class Institution {
    @Id
    @GeneratedValue
    private long id;
    private String name;//list of the institutions church,estates,schools,hostels.
    @OneToMany(mappedBy = "user")
    List<User> users=new ArrayList<User>();

    @OneToMany(mappedBy = "site")
    List<Site> sites=new ArrayList<Site>();

    public Institution(String name, List<User> users, List<Site> sites) {
        this.name = name;
        this.users = users;
        this.sites = sites;
    }

    public Institution() {

    }

    public Institution(String sites, String users) {

    }

    public Institution(List sites, List users) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}

