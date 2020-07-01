package com.pumpkin.dao.impl;

import com.pumpkin.dao.UserDao;
import com.pumpkin.entity.Merchandise;
import com.pumpkin.entity.User;
import com.pumpkin.service.impl.UserImpl;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao{



        public User getUserByAccountIdAndPsw(String accountId,String password){
                User user=new User();
                String sql="SELECT *FROM base_user where accountId=:accountId and password=:password";
                Query query=getSession().createSQLQuery(sql).addEntity(User.class);
                query.setParameter("accountId",accountId);
                query.setParameter("password",password);

                Object obj=query.uniqueResult();
                if(null!=obj){
                        user=(User)obj;
                }
                return user;
        }

        public User findByAccountId(String accountId){
                User user=new User();
                String sql="select *from base_user where accountId=:accountId";
                Query query=getSession().createSQLQuery(sql).addEntity(User.class);
                query.setParameter("accountId",accountId);

                Object obj=query.uniqueResult();
                if(null!=obj){
                        user=(User)obj;
                }return user;
        }

        public User findByBusId(String busId){
                User user=new User();
                String sql="select *from base_user where busId=:busId";
                Query query=getSession().createSQLQuery(sql).addEntity(User.class);
                query.setParameter("busId",busId);
                Object obj=query.uniqueResult();
                if(null!=obj){
                        user=(User)obj;
                }return user;
        }



        public void add(User user){
                save(user);
        }


}