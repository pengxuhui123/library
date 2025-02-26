package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.BorrowService;
import com.book.service.impl.BorrowServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    BorrowService service;
    @Override
    public void init() throws ServletException {
        service=new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/Html;charset=utf-8");
        Context context=new Context();
        User user=(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("student_list",service.getStudentList());
        ThymeleafUtil.process("students.html",context,resp.getWriter());
    }
}
