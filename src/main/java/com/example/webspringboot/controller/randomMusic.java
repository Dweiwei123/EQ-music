package com.example.webspringboot.controller;

import com.example.webspringboot.dao.musicDao;
import com.example.webspringboot.entity.Music;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "randomMusic", value = "/randomMusic")
public class randomMusic extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        musicDao md = new musicDao();
        Music music = new Music();
        List musicList = new ArrayList();

        int n =12;
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (164 - 1)) + 1;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }

        for (int i: result) {
            music = md.querySongById(i);
            musicList.add(music);

        }

        out.print(musicList);


    }

}