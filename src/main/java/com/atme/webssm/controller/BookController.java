package com.atme.webssm.controller;

import com.atme.webssm.pojo.Book;
import com.atme.webssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpSession session, Integer minPrice , Integer maxPrice) {
        if (minPrice != null && maxPrice != null) {
            session.setAttribute("minPrice",minPrice);
            session.setAttribute("maxPrice",maxPrice);
        }
        List<Book> bookList = bookService.getBookList(minPrice, maxPrice);
        session.setAttribute("bookList",bookList);
        return "index";
    }

}
