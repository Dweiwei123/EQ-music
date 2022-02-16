package com.example.webspringboot.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.0.224.17:3306/music?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "6d6hg%PN";

    public Connection connect() {
        Connection conn = null;

        try {
            //JDBC 驱动
            Class.forName(JDBC_DRIVER);

            System.out.println("正在连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("连接成功！\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conn;
        }

    }
}