package com.access.control.models;

public class Visitor {
    private long nationalId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String gender;
    private String phoneNumber;
    private String checkIn;
    private String checkOut;
    private String items[];
    private long institutionId;
    private  String timeIn;
    private String timeOut;
    private String dateIn;
    private String dateOut;
    private String gateIn;
    private String gateOut;
    private long vehicleNumber;
    private String visitingCompany;
    private String visitingPerson;
    private String relationship;
    private String visitingPurpose;

    public Visitor(String firstName, String lastName, String address, String city, String state, String gender, String phoneNumber, String checkIn, String checkOut, String[] items, String timeIn, String timeOut, String dateIn, String dateOut, String gateIn, String gateOut, String visitingCompany, String visitingPerson, String relationship, String visitingPurpose) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.items = items;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.gateIn = gateIn;
        this.gateOut = gateOut;
        this.visitingCompany = visitingCompany;
        this.visitingPerson = visitingPerson;
        this.relationship = relationship;
        this.visitingPurpose = visitingPurpose;
    }
}


