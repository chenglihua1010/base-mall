package com.pumpkin.controller;

import com.pumpkin.entity.Order;
import com.pumpkin.service.impl.OrderImpl;
import com.pumpkin.util.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderController {

        private OrderImpl orderImpl;

        @Resource(name = "orderImpl")
        public void setOrderImpl(OrderImpl orderImpl) {
                this.orderImpl = orderImpl;
        }


        //创建订单，并进入订单支付页面
        @RequestMapping("/addOrder")
        public ModelAndView add(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String busId=RandomUtil.getRandomNickname(10);
                String goodsName=request.getParameter("goodsName");
                String goodsId=request.getParameter("goodsId");
                String goodsPrice=request.getParameter("goodsPrice");
                Double goodsPriceDouble=Double.parseDouble(goodsPrice);
                String count=request.getParameter("quantity");
                Integer countInt=Integer.parseInt(count);
                Double allPrice=countInt*goodsPriceDouble;
                String accountId=request.getParameter("accountId");
                String phone=request.getParameter("phone");
                Integer phoneInteger=Integer.parseInt(phone);
                String address=request.getParameter("address");

                Order order=new Order();
                order.setGoodsName(goodsName);
                order.setGoodsId(goodsId);
                order.setAllPrice(allPrice);
                order.setCount(countInt);
                order.setCreateTime(new Date());
                order.setStatus(1);
                order.setAccountId(accountId);
                order.setBusId(busId);
                order.setPhone(phoneInteger);
                order.setAddress(address);
                orderImpl.add(order);
                modelAndView.addObject("order",order);
                modelAndView.setViewName("payment");
                return modelAndView;
        }
}