package com.mao.web;

import com.mao.mapper.UserMapper;
import com.mao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //调用mybatis
        //获取SqlSessionFactory

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        User user1 = usermapper.selectByUsername(username);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if(user1!=null){
            writer.write("用户已经存在");
        }else {
            usermapper.add(user);
            writer.write("用户注册成功");

            sqlSession.commit();
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
