package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.IntegralDaoImpl;
import com.pumpkin.entity.Integral;
import com.pumpkin.service.IntegralInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("integralImpl")
public class IntegralImpl implements IntegralInterface{
        private IntegralDaoImpl integralDaoImpl;

        @Resource(name = "integralDaoImpl")
        public void setIntegralDaoImpl(IntegralDaoImpl integralDaoImpl) {
                this.integralDaoImpl = integralDaoImpl;
        }

        public void addIntegral(Integral integral){
                integralDaoImpl.addIntegral(integral);
        }

        public  Integral findByAccountId(String accountId){
                return integralDaoImpl.findByAccountId(accountId);
        }
}