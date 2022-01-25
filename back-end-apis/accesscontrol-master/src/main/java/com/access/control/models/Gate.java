package com.access.control.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class Gate {
    private long id;
    private List<String> name;
    private String description;
    private long visitorId;

    @ManyToOne
    @JoinColumn(name="institution_id",nullable=false)
    private Institution  institution;

    public Gate(List<String> name, String description, long visitorId, Institution institution) {
        this.name = name;
        this.description = description;
        this.visitorId = visitorId;

    }
}

