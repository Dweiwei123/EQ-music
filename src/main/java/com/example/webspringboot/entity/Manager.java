package com.example.webspringboot.entity;

public class Manager {
    private String managername;
    private String mpassword;

    public Manager(String managername, String mpassword) {
        this.managername = managername;
        this.mpassword = mpassword;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "{" +
                "\"managername\":\"" + managername + '\"' +
                ", \"mpassword\":\"" + mpassword + '\"' +
                '}';
    }
}
