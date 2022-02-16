package com.example.webspringboot.controller;

import com.example.webspringboot.dao.userDao;
import com.example.webspringboot.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setIntHeader("Refresh", 1);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String u = request.getParameter("username");
        String p = request.getParameter("password");


        userDao ud = new userDao();
        User user = ud.queryUserByUsername(u);

        if (user != null) {
            if (user.getPassword().equals(p)) {
                System.out.print("用户名" + ": " + user.getUsername());
                System.out.print(" 密码" + ": " + user.getPassword());
                System.out.println(" 登录成功");

                request.getSession().setAttribute("User", user.getUsername());
                out.print(1);
            } else {
                System.out.print("用户名" + ": " + u);
                System.out.print(" 密码" + ": " + p);
                System.out.println(" 密码错误 登录失败");

                out.print(-1);

            }
        } else {
            System.out.print("用户名" + ": " + u);
            System.out.print(" 密码" + ": " + p);
            System.out.println(" 未注册 登录失败");

            out.print(0);
        }

    }

}