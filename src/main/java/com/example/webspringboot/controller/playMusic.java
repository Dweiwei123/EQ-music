package com.example.webspringboot.controller;


import com.example.webspringboot.dao.musicDao;
import com.example.webspringboot.entity.Music;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "playMusic", value = "/playMusic")
public class playMusic extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String songname = request.getParameter("songname");

        musicDao md = new musicDao();
        Music music = md.querySongBySongname(songname);

        String url = music.getUrl();

        out.print(url);

    }

}