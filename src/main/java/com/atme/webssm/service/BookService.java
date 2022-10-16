package com.atme.webssm.service;

import com.atme.webssm.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList(Integer minPrice , Integer maxPrice);

    Book getBook(Integer id);

}
