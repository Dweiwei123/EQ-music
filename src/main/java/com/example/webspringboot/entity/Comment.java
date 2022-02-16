package com.example.webspringboot.entity;

import java.sql.Timestamp;

public class Comment {
    private String username;
    private String comments;
    private Timestamp date;
    private String songname;

    public Comment() {

    }

    public Comment(String comments) {
        this.comments = comments;
    }

    public Comment(String username, String comments, String songname) {
        this.username = username;
        this.comments = comments;
        Timestamp stp = new Timestamp(new java.util.Date().getTime());
        this.date = stp;
        this.songname = songname;
    }

    public Comment(String username, String comments, Timestamp date, String songname) {
        this.username = username;
        this.comments = comments;
        this.date = date;
        this.songname = songname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + '\"' +
                ", \"comments\":\"" + comments + '\"' +
                ", \"date\":\"" + date + '\"' +
                ", \"songname\":\"" + songname + '\"' +
                '}';
    }
}
