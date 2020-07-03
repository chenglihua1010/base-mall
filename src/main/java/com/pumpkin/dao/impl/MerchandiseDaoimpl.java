package com.pumpkin.dao.impl;

import com.pumpkin.dao.MerchandiseDao;
import com.pumpkin.entity.Merchandise;
import com.pumpkin.entity.Order;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Repository("merchandiseDaoimpl")
public class MerchandiseDaoimpl  extends BaseDaoImpl<Merchandise> implements MerchandiseDao {

        @Resource(name = "orderDaoImpl")
        public OrderDaoImpl orderDaoImpl;

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

        public void updateMerchandie(Merchandise merchandise){
                update(merchandise);
        }

        public Merchandise findByParam(String goodsName,String origin){
                Merchandise merchandise=new Merchandise();
                String sql="select * from base_merchandise where goodsName=:goodsName or origin=:origin";
//                StringBuilder sql=new StringBuilder("select * from base_merchandise where goodsName=:goodsName");
//                if(goodsName==null){
//                        sql.append("origin=:origin");
//                }
                Query query=getSession().createSQLQuery(sql).addEntity(Merchandise.class);
                query.setParameter("goodsName",goodsName);
                query.setParameter("origin",origin);
                Object object=query.uniqueResult();
                if(null!=object) {
                        merchandise = (Merchandise) object;
                }return merchandise;
        }






        //订单销售排序
        public List<Merchandise> rankByCount(){
                List<Merchandise> merchandiseList=new ArrayList<Merchandise>();
                List<Integer> integerList=new ArrayList<Integer>();
//                StringBuilder sql=new StringBuilder("SELECT id FROM base_order GROUP BY goodsId ORDER BY SUM(count) DESC");
//                StringBuilder sql=new StringBuilder("SELECT goodsId FROM base_order GROUP BY goodsId ORDER BY SUM(count) DESC");
//                Query query=getSession().createSQLQuery(sql.toString()).addEntity(Order.class);
//                List list=query.list();
//
//                if(null!=list){
//                        //这个list用来拼接的
//                        integerList=(List<Integer>)list;
//                }
                 List<String> intList=orderDaoImpl.rankByCount();
                StringBuilder sql1=new StringBuilder("SELECT * from base_merchandise WHERE goodsId in (SELECT goodsId FROM base_order GROUP BY goodsId ) ORDER BY FIELD(goodsId ");
                if(!CollectionUtils.isEmpty(intList)){

                        for (Object goodsId:intList){
                                sql1.append(","+goodsId);
                        }
                        sql1.append(")");
                }

                Query query1=getSession().createSQLQuery(sql1.toString()).addEntity(Merchandise.class);
                List list1=query1.list();
                if(null!=list1){
                        merchandiseList=(List<Merchandise>)list1;
                }return merchandiseList;
        }

}