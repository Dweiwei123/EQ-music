package com.example.webspringboot.controller;

import com.example.webspringboot.dao.musicDao;
import com.example.webspringboot.entity.Music;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "insertMusic", value = "/insertMusic")
public class insertMusic extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        int i = Integer.parseInt(request.getParameter("id"));
        String sn = request.getParameter("songname");
        String sg = request.getParameter("songsinger");
        Date d = Date.valueOf(request.getParameter("date"));
        String p = request.getParameter("album");
        Time t = Time.valueOf(request.getParameter("time")+":00");
        String g = request.getParameter("group");
        String u = request.getParameter("url");

        musicDao md = new musicDao();
        Music music = new Music(i,sn,sg,d,p,t,g,u);
        if (md.addMusic(music) == 1) {
            out.print("<script>alert('添加成功！');\nparent.fun2();\n</script>");
            System.out.println("add music success");
        } else {
            out.print("<script>alert('添加失败！');\nparent.fun2();\n</script>");
            System.out.println("add music failed");
        }
    }

}