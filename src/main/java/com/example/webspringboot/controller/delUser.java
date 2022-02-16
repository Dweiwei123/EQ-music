package com.example.webspringboot.controller;

import com.example.webspringboot.dao.userDao;
import com.example.webspringboot.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delUser", value = "/delUser")
public class delUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String u = request.getParameter("username");

        userDao ud = new userDao();
        User user = new User(u);

        if (ud.delUser(user)) {
            System.out.println("del user success");
        } else
            System.out.println("del user failed");
    }

}