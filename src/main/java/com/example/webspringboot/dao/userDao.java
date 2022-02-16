package com.example.webspringboot.dao;

import com.example.webspringboot.entity.User;
import com.example.webspringboot.service.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//数据访问层，原子性的增删改查，不可拆，
public class userDao {
    private static Connection conn = new dbconnect().connect();

    //以用户名查询用户
    public User queryUserByUsername(String username) {
        try {
            String sql = "select * from user where username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex").charAt(0));
                user.setBirthday(rs.getDate("birthday"));

                pstmt.close();

                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //查询全体用户
    public ResultSet queryAllUser() {
        try {
            String sql = "select * from user";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //以用户id查询用户
    public User queryUserById(int id) {
        try {
            String sql = "select * from user where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex").charAt(0));
                user.setBirthday(rs.getDate("birthday"));

                pstmt.close();

                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //是否存在此用户
    public boolean isExist(User user) {
        return queryUserByUsername(user.getUsername()) != null;
    }

    //添加用户到数据库
    public int addUser(User user) {
        try {
            if (isExist(user)) {
                return -1;
            }

            int id = 0;
            ResultSet rs = queryAllUser();
            while (rs.next())
                id = rs.getInt("id");//获取最后一个用户的id


            String sql = "insert into user values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id + 1);
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, String.valueOf(user.getSex()));
            pstmt.setDate(5, user.getBirthday());

            pstmt.executeUpdate();
            pstmt.close();

            return 1;

        } catch (Exception e) {
            // 处理 JDBC 错误
            e.printStackTrace();
        }

        return 0;
    }

    //删除用户
    public boolean delUser(User user) {
        try {

            if (isExist(user)) {

                String sql = "delete from user where username = ? ";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getUsername());

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

    public boolean updateUser(User user) {
        try {
            if (queryUserById(user.getId()) != null) {
                String sql = "update user set username=?, password=?, sex=?, birthday=? where id=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, String.valueOf(user.getSex()));
                pstmt.setDate(4, user.getBirthday());
                pstmt.setInt(5, user.getId());

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