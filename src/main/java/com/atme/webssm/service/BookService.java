package com.atme.webssm.service;

import com.atme.webssm.pojo.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {
    PageInfo<Book> getBookList(Integer minPrice , Integer maxPrice, Integer pageNum);

    Book getBook(Integer id);

}
