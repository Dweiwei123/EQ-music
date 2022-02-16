package com.example.webspringboot.entity;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private char sex;
    private Date birthday;

    public User() {
        this.username = "***";
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.sex = '0';
        this.birthday = Date.valueOf("2021-07-17");
    }

    public User(String username, String password, char sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = Date.valueOf("2021-07-17");
    }

    public User(String username, String password, char sex, Date birthday) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
    }

    public User(int id, String username, String password, char sex, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"username\":\"" + username + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"sex\":\"" + sex + '\"' +
                ", \"birthday\":\"" + birthday + '\"' +
                '}';
    }
}
