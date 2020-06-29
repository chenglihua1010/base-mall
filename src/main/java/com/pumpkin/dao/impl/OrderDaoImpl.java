package com.pumpkin.dao.impl;

import com.pumpkin.dao.BaseDao;
import com.pumpkin.dao.OrderDao;
import com.pumpkin.entity.Order;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("orderDaoImpl")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao{
        public void add(Order order){
                save(order);
        }


        public Order findByBusId(String busId){
                Order order=new Order();
                String sql="select *from base_order where busId=:busId";
                Query query=this.getSession().createSQLQuery(sql).addEntity(Order.class);
                query.setParameter("busId",busId);
                Object obj=query.uniqueResult();
                if(null!=obj){
                        order=(Order)obj;
                }return order;
        }

        public void updateOrder(Order order){
                update(order);
        }
}