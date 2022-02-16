package com.example.webspringboot.controller;

import com.example.webspringboot.dao.commentDao;
import com.example.webspringboot.entity.Comment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delComment", value = "/delComment")
public class delComment extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String c = request.getParameter("comment");

        commentDao cd = new commentDao();
        Comment comment = new Comment(c);

        System.out.println(c);
        if (cd.delComment(comment)) {
            System.out.println("del success");
        } else
            System.out.println("failed");
    }

}