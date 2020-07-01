package com.pumpkin.dao.impl;

import com.pumpkin.dao.VipDao;
import com.pumpkin.entity.Vip;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("vipDaoImpl")
public class VipDaoImpl extends BaseDaoImpl<Vip> implements VipDao{
        public void addVip(Vip vip){
                save(vip);
        }

        public  void updateVip(Vip vip){
                update(vip);
        }

        public Vip findByAccountId(String accountId){
                Vip vip=new Vip();
                String sql="select * from base_vip where accountId=:accountId";
                Query query=getSession().createSQLQuery(sql).addEntity(Vip.class);
                query.setParameter("accountId",accountId);
                Object object=query.uniqueResult();
                if(null!=object){
                        vip=(Vip)object;
                }return vip;
        }
}