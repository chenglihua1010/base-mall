package com.pumpkin.service.impl;

import com.pumpkin.dao.MerchandiseDao;
import com.pumpkin.dao.MerchandiseDaoimpl;
import com.pumpkin.entity.Merchandise;
import com.pumpkin.service.MerchandiseInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("merchandiseImpl")
public class MerchandiseImpl implements MerchandiseInterface{

        @Resource(name = "merchandiseDaoimpl")
        public MerchandiseDaoimpl merchandiseDaoimpl;


        public MerchandiseDaoimpl getMerchandiseDaoimpl() {
                return merchandiseDaoimpl;
        }

        @Resource(name = "merchandiseDaoimpl")
        public void setMerchandiseDaoimpl(MerchandiseDaoimpl merchandiseDaoimpl) {
                this.merchandiseDaoimpl = merchandiseDaoimpl;
        }

        public List<Merchandise> findAllpumpkin() {
                return this.merchandiseDaoimpl.findAllpumpkin();
        }

        public List<Merchandise> findById(Integer id){
               return this.merchandiseDaoimpl.findById(id);
        }
        public List<Merchandise> findByGn(String goodsName){
                return this.merchandiseDaoimpl.findByGn(goodsName);
        }
}