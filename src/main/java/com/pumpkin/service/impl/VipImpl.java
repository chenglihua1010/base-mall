package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.VipDaoImpl;
import com.pumpkin.entity.Vip;
import com.pumpkin.service.VipInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
@Service("vipImpl")
public class VipImpl implements VipInterface{
        private VipDaoImpl vipDaoImpl;
        @Resource(name = "vipDaoImpl")
        public void setVipDaoImpl(VipDaoImpl vipDaoImpl) {
                this.vipDaoImpl = vipDaoImpl;
        }
        public void addVip(Vip vip){
                vipDaoImpl.addVip(vip);
        }
        public void updateVip(Vip vip){
                vipDaoImpl.updateVip(vip);
        }

        public Vip finDByAccountId(String accountId){
                return vipDaoImpl.findByAccountId(accountId);
        }
}