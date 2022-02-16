package com.example.webspringboot.controller;

import com.example.webspringboot.dao.commentDao;
import com.example.webspringboot.entity.Comment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "insertComment", value = "/insertComment")
public class insertComment extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String u = request.getParameter("username");
        String p = request.getParameter("comments");
        String s = request.getParameter("songname");

        commentDao cd = new commentDao();
        Comment comment = new Comment(u,p,s);

        if (cd.addComment(comment)) {
            out.print(1);
            System.out.println("add comment success");
        } else {
            out.print(0);
            System.out.println("add comment failed");
        }
    }

}