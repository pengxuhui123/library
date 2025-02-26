package com.book.service.impl;

import com.book.dao.BookMapper;
import com.book.entity.Book;
import com.book.service.BookService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServlet;

public class BookServiceImpl implements BookService {

    @Override
    public void addBook(String title, String desc, double price){
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            BookMapper mapper=sqlSession.getMapper(BookMapper.class);
            mapper.addBook(title, desc, price);
        }
    }
}
