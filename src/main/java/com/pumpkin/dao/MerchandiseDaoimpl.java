package com.pumpkin.dao;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pumpkin.dao.impl.BaseDaoImpl;
import com.pumpkin.entity.Merchandise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
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
        private SessionFactory sessionFactory;




        //        @Resource(name = "sessionFactory")
//        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
//                this.setSessionFactory(sessionFactory);
//        }

//        @Resource(name = "sessionFactory")
//        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
//                this.sessionFactory=sessionFactory;
//        }

        public Session getsession(){
                return sessionFactory.getCurrentSession();
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

        public List<Merchandise> findById(Integer id){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                HibernateTemplate hibernateTemplate=this.getHibernateTemplate();
                String hql="from Merchandise where id=:id";


//                Session session=hibernateTemplate.getSessionFactory().getCurrentSession();


                org.hibernate.Query query=this.getsession().createQuery(hql);
                query.setParameter("id",id);
                List list=query.list();

//                List list=hibernateTemplate.find(hql);
                if(null!=list){
                        merchandiseList=(List<Merchandise>)list;
                }
                return merchandiseList;
        }


        public List<Merchandise> findByGn(String goodsName){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                HibernateTemplate hibernateTemplate=new HibernateTemplate();
                String hql="from Merchandise where goodsName=:goodsName";




                List list=hibernateTemplate.find(hql);
                if(null!=list){
                        merchandiseList=(List<Merchandise>)hibernateTemplate.find(hql);
                }
                return merchandiseList;
        }
}