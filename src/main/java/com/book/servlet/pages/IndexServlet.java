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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

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
        context.setVariable("borrow_list",service.getBorrowList());
        context.setVariable("book_count",service.getBookList().size());
        context.setVariable("student_count",service.getStudentList().size());
        ThymeleafUtil.process("index.html",context,resp.getWriter());
    }
}
