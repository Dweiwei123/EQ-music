package com.example.webspringboot.controller;

import com.example.webspringboot.dao.musicDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "music", value = "/music")
public class music extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        musicDao md = new musicDao();
        try {
            ResultSet rs = md.queryAllMusic();

            while (rs.next()) {

                out.println("<tr>\n" +
                        "<td><input type=\"checkbox\"></td>\n" +
                        "<td>" + rs.getInt("id") + "</td>\n" +
                        "<td>\n" + rs.getString("songname") + "</td>\n" +
                        "<td>" + rs.getString("songsinger") + "</td>\n" +
                        "<td>" + rs.getString("date").substring(0,10) + "</td>\n" +
                        "<td>" + rs.getString("album") + "</td>\n" +
                        "<td>" + rs.getString("time").substring(0, 5) + "</td>\n" +
                        "<td>" + rs.getString("group") + "</td>\n" +
                        "<td>\n" +
                        "<div class=\"am-btn-toolbar\">\n" +
                        "<div class=\"am-btn-group am-btn-group-xs\">\n" +
                        "<button type=\"button\" class=\"am-btn am-btn-default am-btn-xs am-text-secondary\" id=\"edit\"><span class=\"am-icon-pencil-square-o\"></span> 编辑</button>\n" +
                        "<button type=\"button\" class=\"am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only\" id=\"del\"><span class=\"am-icon-trash-o\"></span> 删除</button>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n");

            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

}