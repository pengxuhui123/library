package com.book.servlet.manage;

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

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    BorrowService service;
    @Override
    public void init() throws ServletException {
        service=new BorrowServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/Html;charset=utf-8");
        Context context=new Context();
        context.setVariable("book_list",service.getActiveBookList());
        context.setVariable("student_list",service.getStudentList());
        ThymeleafUtil.process("add-borrow.html",context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/Html;charset=utf-8x");
        int sid=Integer.parseInt(req.getParameter("student"));
        int bid=Integer.parseInt(req.getParameter("book"));
        service.addBorrow(sid,bid);
        resp.sendRedirect("index");
    }
}
