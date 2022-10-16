package com.atme.webssm.service.impl;

import com.atme.webssm.mappers.CartItemDAO;
import com.atme.webssm.mappers.OrderDAO;
import com.atme.webssm.mappers.OrderItemDAO;
import com.atme.webssm.pojo.CartItem;
import com.atme.webssm.pojo.OrderBean;
import com.atme.webssm.pojo.OrderItem;
import com.atme.webssm.pojo.User;
import com.atme.webssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderItemDAO orderItemDAO;
    @Autowired
    private CartItemDAO cartItemDAO;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDAO.addOrderBean(orderBean);
        User user = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }

        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderList = orderDAO.getOrderList(user);
        for (OrderBean order : orderList) {
            order.setTotalBookCount(orderDAO.getOrderTotalCount(order));
        }
        return orderList;
    }
}
