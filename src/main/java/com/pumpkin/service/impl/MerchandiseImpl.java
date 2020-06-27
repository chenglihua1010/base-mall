package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.MerchandiseDaoimpl;
import com.pumpkin.entity.Merchandise;
import com.pumpkin.service.MerchandiseInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service("merchandiseImpl")
public class MerchandiseImpl implements MerchandiseInterface{

        @Resource(name = "merchandiseDaoimpl")
        public MerchandiseDaoimpl merchandiseDaoimpl;


        public void deleteById(Integer id){
                merchandiseDaoimpl.deleteByID(id);
        }

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

        public List<Merchandise> findByGI(String goodsId){
                return this.merchandiseDaoimpl.findByGI(goodsId);
        }


        public void add(Merchandise merchandise){
                merchandiseDaoimpl.add(merchandise);
        }
}