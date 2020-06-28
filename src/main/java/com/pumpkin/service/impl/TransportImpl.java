package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.TransportDaoImpl;
import com.pumpkin.entity.Transport;
import com.pumpkin.service.TransportInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
@Service("transportImpl")
public class TransportImpl implements TransportInterface{
        private TransportDaoImpl transportDaoImpl;

        @Resource(name = "transportDaoImpl")
        public void setTransportDaoImpl(TransportDaoImpl transportDaoImpl) {
                this.transportDaoImpl = transportDaoImpl;
        }

        public void add(Transport transport){
                transportDaoImpl.add(transport);

        }


}