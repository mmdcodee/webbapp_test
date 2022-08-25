package com.mao.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post
//        request.setCharacterEncoding("UTF-8");
        System.out.println("demo2");
        FileInputStream fis = new FileInputStream("D:\\java\\pic\\Figure_1.png");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis,os);
        fis.close();

        request.getRequestDispatcher("/req1").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
