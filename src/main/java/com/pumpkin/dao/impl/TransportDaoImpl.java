package com.pumpkin.dao.impl;
//entity,dao,service,repository

import com.pumpkin.dao.TransportDao;
import com.pumpkin.entity.Transport;
import com.pumpkin.service.TransportInterface;
import org.springframework.stereotype.Repository;


@Repository("transportDaoImpl")
public class TransportDaoImpl extends BaseDaoImpl<Transport> implements TransportDao{
        public void add(Transport transport){
                save(transport);
        }
}