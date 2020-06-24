package com.pumpkin.dao;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pumpkin.dao.impl.BaseDaoImpl;
import com.pumpkin.entity.Merchandise;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("merchandiseDaoimpl")
public class MerchandiseDaoimpl  extends HibernateDaoSupport implements MerchandiseDao{



        @Resource(name = "sessionFactory")
        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
                this.setSessionFactory(sessionFactory);
        }


        public List<Merchandise> findAllpumpkin(){
                List<Merchandise> merchandiseList=findAll();
                return merchandiseList;
        }

        public void save(Merchandise merchandise) {

        }

        public void delete(Integer id) {

        }

        public void delete(Merchandise merchandise) {

        }

        public void update(Merchandise merchandise) {

        }

        public Merchandise getById(Integer id) {
                HibernateTemplate template=this.getHibernateTemplate();
                return (Merchandise) template.get(Merchandise.class, id);
        }

        public Integer getTotalCount(DetachedCriteria dc) {
                return null;
        }

        public List<Merchandise> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
                return null;
        }


        public List<Merchandise> findAll() {
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                HibernateTemplate template=this.getHibernateTemplate();
                String hql="from Merchandise";
                List list=template.find(hql);
                if(null !=list){
                       merchandiseList=(List<Merchandise>)template.find(hql);
                }
                return merchandiseList;
       }

        public List<Merchandise> findByName(String goodsName){
                HibernateTemplate template=this.getHibernateTemplate();
                Merchandise merchandise=(Merchandise) template.get(Merchandise.class, goodsName);
                List<Merchandise> merchandiseList=findAll();
                return merchandiseList;
        }

        public List<Merchandise> findById(Integer id){
                HibernateTemplate template=this.getHibernateTemplate();
                Merchandise merchandise=(Merchandise) template.get(Merchandise.class, id);
                List<Merchandise> merchandiseList=findAll();
                return merchandiseList;
        }

}