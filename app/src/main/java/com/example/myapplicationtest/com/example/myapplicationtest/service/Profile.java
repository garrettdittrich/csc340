package com.example.myapplicationtest.com.example.myapplicationtest.service;



public class Profile {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile() {

    }

    public Profile(Profile profile) {
        this.id = profile.getId();
        this.username = profile.getUsername();
        this.password = profile.getPassword();
    }

}

