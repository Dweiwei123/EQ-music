package com.example.webspringboot.controller;

import com.example.webspringboot.dao.commentDao;
import com.example.webspringboot.entity.Comment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "queryAllComment", value = "/queryAllComment")
public class queryAllComment extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        commentDao cd = new commentDao();
        try {
            ResultSet rs = cd.queryAllComment();

            List commentList = new ArrayList();
            while (rs.next()) {

                Comment comment = new Comment(rs.getString("username"),rs.getString("comments"),rs.getTimestamp("date"),rs.getString("songname"));
                commentList.add(comment);
            }
            out.println(commentList);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}