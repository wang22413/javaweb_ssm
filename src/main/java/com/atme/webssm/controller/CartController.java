package com.atme.webssm.controller;

import com.atme.webssm.pojo.*;
import com.atme.webssm.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/cart")
    public String index(HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return "user/login";
        }
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("user",user);
        return "cart/cart";
    }

    @RequestMapping(value = "/addCart/{bookId}",method = RequestMethod.GET)
    public String addCart(@PathVariable("bookId") Integer bookId , HttpSession session) {
        User user = (User)session.getAttribute("user");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());
        return "redirect:/";
    }

    @RequestMapping("/editCart/{book}/{buyCount}")
    public String editCart(@PathVariable("book") Integer book ,@PathVariable("buyCount") Integer buyCount ) {
        if (buyCount >= 1) {
            cartItemService.updateCartId(new CartId(book,buyCount));
        }
        return "redirect:/cart";
    }

    @RequestMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable("id") Integer id) {
        cartItemService.deleteCart(id);
        return "redirect:/cart";
    }

}
