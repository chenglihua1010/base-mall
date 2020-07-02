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
import java.util.Map;

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
        public List<String> rankByCount() {
                List<Order> merchandiseList = new ArrayList<Order>();
                List<String> StringList = new ArrayList<String>();
                StringBuilder sql=new StringBuilder("SELECT goodsId FROM base_order GROUP BY goodsId ORDER BY SUM(count) DESC");
                Query query = getSession().createSQLQuery(sql.toString()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List list = query.list();
                if (null != list) {
                        //这个list用来拼接的
                        List<Map<String,String>> mapList=(List<Map<String,String>>)list;
                        for (Map<String,String> map:mapList) {
                                StringList.add(map.get("goodsId"));
                        }
                }

                return StringList;
        }
}