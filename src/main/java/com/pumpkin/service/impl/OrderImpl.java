package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.OrderDaoImpl;
import com.pumpkin.entity.Order;
import com.pumpkin.service.OrderInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("orderImpl")
public class OrderImpl implements OrderInterface{
        private OrderDaoImpl orderDaoImpl;

        @Resource(name = "orderDaoImpl")
        public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
                this.orderDaoImpl = orderDaoImpl;
        }

        public void add(Order order){
                orderDaoImpl.add(order);
        }
}