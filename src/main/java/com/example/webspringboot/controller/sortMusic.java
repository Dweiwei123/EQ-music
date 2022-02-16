package com.example.webspringboot.controller;

import com.example.webspringboot.dao.musicDao;
import com.example.webspringboot.entity.Music;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sortMusic", value = "/sortMusic")
public class sortMusic extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setIntHeader("Refresh", 1);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String group = request.getParameter("group");

        musicDao md = new musicDao();
        ResultSet rs;
        if(group.equals("all"))
            rs = md.queryAllMusic();
        else
            rs = md.querySongByGroup(group);
        List musicList = new ArrayList();

        try {
            while (rs.next()) {
                Music music = new Music(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getTime(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                musicList.add(music);
            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }

        out.print(musicList);

    }

}