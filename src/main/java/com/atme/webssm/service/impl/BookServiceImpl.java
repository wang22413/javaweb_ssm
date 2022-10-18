package com.atme.webssm.service.impl;

import com.atme.webssm.mappers.BookDAO;
import com.atme.webssm.pojo.Book;
import com.atme.webssm.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public PageInfo<Book> getBookList(Integer minPrice, Integer maxPrice, Integer pageNum) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,10);
        List<Book> list = bookDAO.getBookList(minPrice, maxPrice);
        PageInfo<Book> bookPageInfo = new PageInfo<>(list, 5);
        return bookPageInfo;
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
