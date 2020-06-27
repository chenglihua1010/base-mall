package com.pumpkin.dao.impl;

import com.pumpkin.dao.BaseDao;
import com.pumpkin.dao.OrderDao;
import com.pumpkin.entity.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDaoImpl")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{
        public void add(Order order){
                save(order);
        }
}