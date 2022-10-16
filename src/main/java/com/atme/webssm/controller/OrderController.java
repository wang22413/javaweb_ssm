package com.atme.webssm.controller;

import com.atme.webssm.mappers.OrderItemDAO;
import com.atme.webssm.pojo.OrderBean;
import com.atme.webssm.pojo.User;
import com.atme.webssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String order(HttpSession session) {

        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDate();
        int hour = now.getHours();
        int min = now.getMinutes();
        int sec = now.getSeconds();

        User user = (User) session.getAttribute("user");

        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + year + month + day + hour + min + sec);
        orderBean.setOrderDate(LocalDateTime.now().toString().substring(0,19).replace("T"," "));
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);
        String orderNo = orderBean.getOrderNo();

        session.setAttribute("orderNo",orderNo);

        return "cart/checkout";
    }

    @RequestMapping("myorder")
    private String MyOrder(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderBean> orderList = orderService.getOrderList(user);
        session.setAttribute("orderList",orderList);
        return "order/order";
    }

}
