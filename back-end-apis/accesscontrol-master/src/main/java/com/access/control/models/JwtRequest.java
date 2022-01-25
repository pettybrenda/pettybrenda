package com.access.control.models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String userName;
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String userName, String password) {
        this.setUsername(userName);
        this.setPassword(password);
    }

    public String getUsername() {

        return this.userName;
    }

    public void setUsername(String userName) {

        this.userName = userName;
    }

    public String getPassword() {

        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
