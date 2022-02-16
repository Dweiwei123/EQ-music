package com.example.webspringboot.dao;

import com.example.webspringboot.entity.Music;
import com.example.webspringboot.service.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据访问层，原子性的增删改查，不可拆，
public class musicDao {
    private static Connection conn = new dbconnect().connect();

    //查询所有歌曲
    public ResultSet queryAllMusic() {
        try {
            String sql = "select * from music where lrc is not null";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet queryAllSongBySongname(String songname) {
        try {
            String sql = "select * from music where songname like \"%\"?\"%\" order by songname asc";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, songname);

            ResultSet rs = pstmt.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以歌曲名查询歌曲
    public Music querySongBySongname(String songname) {
        try {
            String sql = "select * from music where songname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, songname);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                Music music = new Music();

                music.setSongname(rs.getString("songname"));
                music.setSongsinger(rs.getString("songsinger"));
                music.setDate(rs.getDate("date"));
                music.setAlbum(rs.getString("album"));
                music.setTime(rs.getTime("time"));
                music.setGroup(rs.getString("group"));
                music.setUrl(rs.getString("url"));
                music.setLrc(rs.getString("lrc"));
                music.setImage(rs.getString("image"));

                pstmt.close();

                return music;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以歌曲id查询歌曲
    public Music querySongById(int id) {
        try {
            String sql = "select * from music where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                Music music = new Music();

                music.setId(rs.getInt("id"));
                music.setSongname(rs.getString("songname"));
                music.setSongsinger(rs.getString("songsinger"));
                music.setDate(rs.getDate("date"));
                music.setAlbum(rs.getString("album"));
                music.setImage(rs.getString("image"));
                music.setLrc(rs.getString("lrc"));
                music.setTime(rs.getTime("time"));
                music.setGroup(rs.getString("group"));
                music.setUrl(rs.getString("url"));

                pstmt.close();

                return music;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以歌曲分类查询歌曲
    public ResultSet querySongByGroup(String group) {
        try {
            String sql = "select * from music where `group` = ? and lrc is not null";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, group);

            ResultSet rs = pstmt.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //是否存在此音乐
    public boolean isExist(Music music) {
        return querySongById(music.getId()) == null ? false : true;
    }

    //添加歌曲到数据库
    public int addMusic(Music music) {

        try {
            if (isExist(music)) {
                return -1;
            }

            String sql = "insert into music values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, music.getId());
            pstmt.setString(2, music.getSongname());
            pstmt.setString(3, music.getSongsinger());
            pstmt.setDate(4, music.getDate());
            pstmt.setString(5, music.getAlbum());
            pstmt.setTime(6, music.getTime());
            pstmt.setString(7, music.getGroup());
            pstmt.setString(8, music.getUrl());

            pstmt.executeUpdate();
            pstmt.close();

            return 1;

        } catch (SQLException e) {
            // 处理 JDBC 错误
            e.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
        return 0;
    }

    //删除歌曲
    public boolean delMusic(Music music) {
        try {

            if (isExist(music)) {

                String sql = "delete from music where songname = ? ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, music.getSongname());

                pstmt.executeUpdate();
                pstmt.close();

                return true;
            } else
                return false;

        } catch (Exception e) {
            // 处理 JDBC 错误
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMusic(Music music) {
        try {

            if (querySongById(music.getId()) != null) {
                String sql = "update music set songname=?, songsinger=?, date=?, album=?, time=?, `group`=? where id=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, music.getSongname());
                pstmt.setString(2, music.getSongsinger());
                pstmt.setDate(3, music.getDate());
                pstmt.setString(4, music.getAlbum());
                pstmt.setTime(5, music.getTime());
                pstmt.setString(6, music.getGroup());
                pstmt.setInt(7, music.getId());

                pstmt.executeUpdate();
                pstmt.close();

                return true;
            } else
                return false;

        } catch (Exception e) {
            // 处理 JDBC 错误
            e.printStackTrace();
            return false;
        }
    }
}