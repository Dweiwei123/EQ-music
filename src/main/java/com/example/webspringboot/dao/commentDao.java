package com.example.webspringboot.dao;

import com.example.webspringboot.entity.Comment;
import com.example.webspringboot.service.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//数据访问层，原子性的增删改查，不可拆，
public class commentDao {
    private static Connection conn = new dbconnect().connect();

    //查询所有评论
    public ResultSet queryAllComment() {
        try {
            String sql = "select * from comment";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            return pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以歌曲名查询评论
    public ResultSet queryCommentBySongname(String songname) {
        try {
            String sql = "select * from comment where songname=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, songname);

            ResultSet rs = pstmt.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以用户名查询评论
    public Comment queryCommentByUserName(String username) {
        try {
            String sql = "select * from comment where username like '%'?'%'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                Comment comment = new Comment();

                comment.setUsername(rs.getString("username"));
                comment.setComments(rs.getString("comments"));
                comment.setDate(rs.getTimestamp("date"));
                comment.setSongname(rs.getString("songname"));

                pstmt.close();

                return comment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //添加评论到数据库
    public boolean addComment(Comment comment) {

        try {
            String sql = "insert into comment values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comment.getUsername());
            pstmt.setString(2, comment.getComments());
            pstmt.setTimestamp(3, comment.getDate());
            pstmt.setString(4, comment.getSongname());

            pstmt.executeUpdate();
            pstmt.close();

            return true;

        } catch (Exception e) {
            // 处理 JDBC 错误
            e.printStackTrace();
        }// 处理 Class.forName 错误

        return false;
    }

    //删除评论
    public boolean delComment(Comment comment) {
        try {
            String sql = "delete from comment where comments = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comment.getComments());

            pstmt.executeUpdate();
            pstmt.close();

            return true;
        } catch (Exception e) {
            // 处理 JDBC 错误
            e.printStackTrace();
            return false;
        }
    }

}