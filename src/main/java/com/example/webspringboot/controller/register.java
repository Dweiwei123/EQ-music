package com.example.webspringboot.controller;

import com.example.webspringboot.dao.userDao;
import com.example.webspringboot.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String u = request.getParameter("username");
        String p = request.getParameter("password");
        char s = request.getParameter("sex").charAt(0);
        String ap = request.getParameter("againPassword");

        User user = new User(u, p, s);
        userDao ud = new userDao();

        if (ud.queryUserByUsername(u) != null) {
            System.out.println("用户名" + u + "已存在");

            out.println(4);
        } else if (u.equals("") || p.equals("") || ap.equals("")) {
            System.out.println("用户名或密码不能为空");
            out.println(0);

        } else if (u.contains(" ") || p.contains(" ") || ap.contains(" ")) {
            System.out.println("用户名或密码不能包含空格");
            out.println(3);

        } else if (!p.equals(ap)) {
            System.out.println("两次密码不一致！");
            out.println(2);

        } else {
            ud.addUser(user);

            System.out.print("用户名" + ": " + user.getUsername());
            System.out.print("密码" + ": " + user.getPassword());
            System.out.print("性别" + ": " + user.getSex());
            System.out.print("生日" + ": " + user.getBirthday());
            System.out.println("注册成功");

            request.getSession().setAttribute("User", user.getUsername());
            out.println(1);

        }

    }

}
