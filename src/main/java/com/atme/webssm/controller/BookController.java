package com.atme.webssm.controller;

import com.atme.webssm.pojo.Book;
import com.atme.webssm.pojo.Price;
import com.atme.webssm.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 开始界面的处理,或一些旧数据的删除
     * @param session
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpSession session) {
        Integer pageNum = (Integer) session.getAttribute("pageNum");
        Integer minPrice = (Integer)session.getAttribute("minPrice");
        Integer maxPrice = (Integer)session.getAttribute("maxPrice");
        session.removeAttribute("pageNum");
        session.removeAttribute("minPrice");
        session.removeAttribute("maxPrice");
        PageInfo<Book> bookList = bookService.getBookList(minPrice, maxPrice, pageNum);
        session.setAttribute("bookList",bookList);
        return "index";
    }

    /**
     * 价格查询
     * @param session
     * @param price
     * @return
     */
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String book(HttpSession session, Price price) {
        Integer minPrice = price.getMinPrice();
        Integer maxPrice = price.getMaxPrice();
        Integer pageNum = price.getPageNum();
        session.setAttribute("minPrice",minPrice);
        session.setAttribute("maxPrice",maxPrice);
        session.setAttribute("pageNum",pageNum);
        PageInfo<Book> bookList = bookService.getBookList(minPrice, maxPrice, pageNum);
        session.setAttribute("bookList",bookList);
        return "index";
    }

    /**
     * 转发处理thymeleaf渲染
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/book/page/{pageNum}",method = RequestMethod.GET)
    public String page(@PathVariable("pageNum") Integer pageNum) {
        return "redirect:/book/" + pageNum;
    }

    /**
     * 分页处理
     * @param session
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/book/{pageNum}",method = RequestMethod.GET)
    public String book(HttpSession session, @PathVariable("pageNum") Integer pageNum) {
        Integer minPrice = (Integer)session.getAttribute("minPrice");
        Integer maxPrice = (Integer)session.getAttribute("maxPrice");
        session.setAttribute("minPrice",minPrice);
        session.setAttribute("maxPrice",maxPrice);
        session.setAttribute("pageNum",pageNum);
        PageInfo<Book> bookList = bookService.getBookList(minPrice, maxPrice, pageNum);
        session.setAttribute("bookList",bookList);
        return "redirect:/";
    }

}
