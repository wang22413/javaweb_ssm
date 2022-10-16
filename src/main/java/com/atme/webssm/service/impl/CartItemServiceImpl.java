package com.atme.webssm.service.impl;

import com.atme.webssm.mappers.CartItemDAO;
import com.atme.webssm.mappers.UserDAO;
import com.atme.webssm.pojo.*;
import com.atme.webssm.service.BookService;
import com.atme.webssm.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDAO cartItemDAO;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void addCartId(CartId cartId) {
        cartItemDAO.addCartItem(cartId);
    }

    @Override
    public void updateCartId(CartId cartId) {
        cartItemDAO.updateCartItem(cartId);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem , Cart cart) {
        CartId cartId = new CartId(null,cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUser().getId());
        if (cart!=null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap==null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                cartItemTemp.setUser(new User(cartItem.getUser().getId()));
                cartId = new CartId(null,cartItemTemp.getBook().getId(),cartItemTemp.getBuyCount(),cartItemTemp.getUser().getId());
                updateCartId(cartId);
            } else {
                addCartId(cartId);
            }
        } else {
            addCartId(cartId);
        }

    }

    @Override
    public Cart getCart(User user) {
        List<CartId> cartIdList = cartItemDAO.getCartItemList(user);
        Map<Integer,CartItem> cartItemMap = new HashMap<>(cartIdList.size());
        for (CartId cartId : cartIdList) {
            CartItem cartItem = new CartItem();
            Book book = bookService.getBook(cartId.getBook());
            cartItem.setId(cartId.getId());
            cartItem.setBook(book);
            cartItem.setBuyCount(cartId.getBuyCount());
            cartItem.setUser(userDAO.getUserById(cartId.getId()));
            cartItemMap.put(cartId.getBook(),cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return  cart;
    }

    @Override
    public void deleteCart(Integer id) {
        cartItemDAO.delCartItem(new CartItem(id));
    }
}
