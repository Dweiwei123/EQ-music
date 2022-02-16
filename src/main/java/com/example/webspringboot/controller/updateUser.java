package com.example.webspringboot.controller;

import com.example.webspringboot.dao.userDao;
import com.example.webspringboot.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "updateUser", value = "/updateUser")
public class updateUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        int i = Integer.parseInt(request.getParameter("id"));;
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        char s = request.getParameter("sex").charAt(0);
        Date b = Date.valueOf(request.getParameter("birthday"));

        userDao ud = new userDao();
        User user = new User(i,u,p,s,b);
        if (ud.updateUser(user)) {
            out.print("<script>alert('更新成功！');\nparent.fun2();\n</script>");
            System.out.println("update user success");
        } else
            out.print("<script>alert('更新失败！');\nparent.fun2();\n</script>");
            System.out.println("update user failed");
    }

}