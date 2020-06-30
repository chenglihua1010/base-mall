package com.pumpkin.dao.impl;

import com.pumpkin.dao.IntegralDao;
import com.pumpkin.entity.Integral;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("integralDaoImpl")
public class IntegralDaoImpl extends BaseDaoImpl<Integral> implements IntegralDao{
        public void addIntegral(Integral integral){
                save(integral);
        }
        public Integral findByAccountId(String accountId){
                Integral integral=new Integral();
                String sql="select from*base_integral where accountId=:accountId";
                Query query=getSession().createSQLQuery(sql).addEntity(Integral.class);
                query.setParameter("accountId",accountId);
                Object object=query.uniqueResult();
                if(null!=object){
                        integral=(Integral)object;
                }return integral;
        }
}