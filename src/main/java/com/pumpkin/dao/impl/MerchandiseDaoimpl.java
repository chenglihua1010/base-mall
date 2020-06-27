package com.pumpkin.dao.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pumpkin.dao.MerchandiseDao;
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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Repository("merchandiseDaoimpl")
public class MerchandiseDaoimpl  extends BaseDaoImpl<Merchandise> implements MerchandiseDao {



//
//        @Resource(name = "sessionFactory")
//        private SessionFactory sessionFactory;




        //        @Resource(name = "sessionFactory")
//        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
//                this.setSessionFactory(sessionFactory);
//        }

//        @Resource(name = "sessionFactory")
//        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
//                this.sessionFactory=sessionFactory;
//        }

//        public Session getsession(){
//                return sessionFactory.getCurrentSession();
//        }


        public List<Merchandise> findAllpumpkin(){
                List<Merchandise> merchandiseList=findAll();

                return merchandiseList;
        }

//        public void save(Merchandise merchandise) {
//                super.save(merchandise);
//        }
//
//        public void delete(Integer id) {
//                super.delete(id);
//        }
//
//        public void delete(Merchandise merchandise) {
//
//        }
//
//        public void update(Merchandise merchandise) {
//
//        }

        public void deleteByID(Integer id){
                Merchandise merchandise=new Merchandise();
                merchandise.setId(id);
                delete(merchandise);
        }

        public void add(Merchandise merchandise){
              save(merchandise);
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

//        @Transactional(readOnly=true)
        public List<Merchandise> findById(Integer id){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                HibernateTemplate hibernateTemplate=this.getHibernateTemplate();
                String hql="from Merchandise where id=:id";
                Query query=getSession().createQuery(hql);
                query.setParameter("id",id);
                List list=query.list();
                if(null!=list){
                        merchandiseList=(List<Merchandise>)list;
                }
                return merchandiseList;
        }


        public List<Merchandise> findByGn(String goodsName){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
//                String hql="from Merchandise where goodsName=:goodsName";
//                org.hibernate.Query query=this.getsession().createQuery(hql);
                String sql="SELECT  * from base_merchandise where goodsName=:goodsName";
                org.hibernate.Query query=this.getSession().createSQLQuery(sql).addEntity(Merchandise.class);

                query.setParameter("goodsName",goodsName);
                List list=query.list();
                if(null!=list){
                        merchandiseList=(List<Merchandise>)list;
                }
                return merchandiseList;
        }

        public List<Merchandise> findByGI(String goodsId){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                String sql="SELECT * from base_merchandise where goodsId=:goodsId";
                org.hibernate.Query query=this.getSession().createSQLQuery(sql).addEntity(Merchandise.class);
                query.setParameter("goodsId",goodsId);
                List list=query.list();
                if(null!=list){
                        merchandiseList=(List<Merchandise>) list;
                }
                return merchandiseList;

        }
}