package com.access.control.models;

import javax.persistence.*;

public class Site {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name="institution_id",nullable=false)
    private Institution institution;

    public Site(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Site() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
