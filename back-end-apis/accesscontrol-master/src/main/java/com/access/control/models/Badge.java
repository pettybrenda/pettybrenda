package com.access.control.models;

public class Badge {
    private long id;
    private long badgeNumber;
    private String description;
    private String available;

    public Badge(long badgeNumber, String description, String available) {
        this.badgeNumber = badgeNumber;
        this.description = description;
        this.available = available;
    }
}
