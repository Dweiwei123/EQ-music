package com.example.webspringboot.entity;

import java.sql.Date;
import java.sql.Time;

public class Music {
    private int id;
    private String songname;
    private String songsinger;
    private Date date;
    private String album;
    private Time time;
    private String group;
    private String url;
    private String lrc;
    private String image;

    public Music() {
        ;
    }

    public Music(int id) {
        this.id = id;
    }

    public Music(String songname) {
        this.songname = songname;
    }

    public Music(int id, String songname, String songsinger, Date date, String album, Time time, String group) {
        this.id = id;
        this.songname = songname;
        this.songsinger = songsinger;
        this.date = date;
        this.album = album;
        this.time = time;
        this.group = group;
    }

    public Music(int id, String songname, String songsinger, Date date, String album, Time time, String group, String url) {
        this.id = id;
        this.songname = songname;
        this.songsinger = songsinger;
        this.date = date;
        this.album = album;
        this.time = time;
        this.group = group;
        this.url = url;
    }

    public Music(String songname, String songsinger, Date date, String album, Time time, String group, String url) {
        this.songname = songname;
        this.songsinger = songsinger;
        this.date = date;
        this.album = album;
        this.time = time;
        this.group = group;
        this.url = url;
    }

    public Music(int id, String songname, String songsinger, Date date, String album, Time time, String group, String url, String lrc, String image) {
        this.id = id;
        this.songname = songname;
        this.songsinger = songsinger;
        this.date = date;
        this.album = album;
        this.time = time;
        this.group = group;
        this.url = url;
        this.lrc = lrc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongsinger() {
        return songsinger;
    }

    public void setSongsinger(String songsinger) {
        this.songsinger = songsinger;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"songname\":\"" + songname + '\"' +
                ", \"songsinger\":\"" + songsinger + '\"' +
                ", \"date\":\"" + date + '\"' +
                ", \"album\":\"" + album + '\"' +
                ", \"time\":\"" + time + '\"' +
                ", \"group\":\"" + group + '\"' +
                ", \"url\":\"" + url + '\"' +
                ", \"lrc\":\"" + lrc.split("\n") + '\"' +
                ", \"image\":\"" + image + '\"' +
                '}';
    }
}
