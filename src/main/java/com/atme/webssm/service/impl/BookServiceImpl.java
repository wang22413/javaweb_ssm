package com.atme.webssm.service.impl;

import com.atme.webssm.mappers.BookDAO;
import com.atme.webssm.pojo.Book;
import com.atme.webssm.service.BookService;
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
    public List<Book> getBookList(Integer minPrice, Integer maxPrice) {
        return bookDAO.getBookList(minPrice, maxPrice);
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
