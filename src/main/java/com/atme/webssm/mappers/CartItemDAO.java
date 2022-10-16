package com.atme.webssm.mappers;


import com.atme.webssm.pojo.CartId;
import com.atme.webssm.pojo.CartItem;
import com.atme.webssm.pojo.User;

import java.util.List;

public interface CartItemDAO {

    void addCartItem(CartId cartId);

    void updateCartItem(CartId cartId);

    List<CartId> getCartItemList(User user);

    void delCartItem(CartItem cartItem);

}
