package com.atme.webssm.controller;

import com.atme.webssm.mappers.UserDAO;
import com.atme.webssm.pojo.Cart;
import com.atme.webssm.pojo.User;
import com.atme.webssm.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/user")
    public String user() {
        return "user/login";
    }

    @PostMapping("/user/login")
    public String login(User user, HttpSession session) {
        user = userDAO.getUser(user.getUname(), user.getPwd());
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping("/regist")
    public String regist() {
        return "user/regist";
    }

    @RequestMapping(value = "/user/regist",method = RequestMethod.POST)
    public String addUser(String verifyCode , HttpSession session, HttpServletResponse response, User user) throws IOException {
        Object key = session.getAttribute(KAPTCHA_SESSION_KEY);
        if (verifyCode!=null && key.equals(verifyCode)) {
            user.setRole(0);
            userDAO.addUser(user);
            return "user/login";
        }else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('验证码错误!')</script>");
        }
        return "user/regist";
    }
}
