package com.pumpkin.dao.impl;

import com.pumpkin.dao.BaseDao;
import com.pumpkin.dao.OrderDao;
import com.pumpkin.entity.Order;
import com.sun.org.apache.xml.internal.security.encryption.Transforms;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
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

        //订单销售排序
        public List<Integer> rankByCount() {
                List<Order> merchandiseList = new ArrayList<Order>();
                List<Integer> integerList = new ArrayList<Integer>();
                StringBuilder sql=new StringBuilder("SELECT goodsId FROM base_order GROUP BY goodsId ORDER BY SUM(count) DESC");
//                StringBuilder sql = new StringBuilder("SELECT goodsId FROM Order GROUP BY goodsId ORDER BY SUM(count) DESC");
                Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.TO_LIST);
                List list = query.list();

                if (null != list) {
                        //这个list用来拼接的
                        integerList = (List<Integer>) list;
                }
                return integerList;
        }
}