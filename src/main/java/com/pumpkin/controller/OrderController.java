package com.pumpkin.controller;

import com.pumpkin.entity.Order;
import com.pumpkin.service.impl.OrderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

        private OrderImpl orderImpl;

        @Resource(name = "orderImpl")
        public void setOrderImpl(OrderImpl orderImpl) {
                this.orderImpl = orderImpl;
        }

        @RequestMapping("/addOrder")
        public ModelAndView add(HttpServletRequest request){
            ModelAndView modelAndView=new ModelAndView();
                String goodsName=request.getParameter("goodsName");
                String goodsId=request.getParameter("goodsId");
                Order order=new Order();
                order.setGoodsName(goodsName);
                orderImpl.add(order);
                return modelAndView;
        }
}