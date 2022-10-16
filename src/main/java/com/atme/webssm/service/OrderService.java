package com.atme.webssm.service;

import com.atme.webssm.pojo.OrderBean;
import com.atme.webssm.pojo.User;

import java.util.List;

public interface OrderService {

    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
