package com.atme.webssm.mappers;

import com.atme.webssm.pojo.OrderBean;
import com.atme.webssm.pojo.User;

import java.util.List;

public interface OrderDAO {

    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalCount(OrderBean orderBean);
}
