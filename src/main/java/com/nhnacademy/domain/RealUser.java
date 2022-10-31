package com.nhnacademy.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealUser implements User{
    private String id;
    private String pwd;
    private String name;
    private String profileFileName;

    public RealUser(String id, String pwd, String name, String profileFileName) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.profileFileName = profileFileName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public void setPassword(String password) {
        this.pwd = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return profileFileName;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}
