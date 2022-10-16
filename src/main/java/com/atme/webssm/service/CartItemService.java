package com.atme.webssm.service;


import com.atme.webssm.pojo.Cart;
import com.atme.webssm.pojo.CartId;
import com.atme.webssm.pojo.CartItem;
import com.atme.webssm.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface CartItemService {

    void addCartId(CartId cartId);
    void updateCartId(CartId cartId);
    void addOrUpdateCartItem(CartItem cartItem , Cart cart);
    Cart getCart(User user);
    void deleteCart(@Param("id") Integer id);

}
