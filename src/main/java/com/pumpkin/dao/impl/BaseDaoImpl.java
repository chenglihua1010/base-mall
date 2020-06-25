package com.pumpkin.dao.impl;

import com.pumpkin.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
@Repository("baseDaoImpl")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {



        @Resource(name = "sessionFactory")
        private SessionFactory sessionFactory;


//        @Resource(name = "sessionFactory")
//        public final void setSuperSessionFactory(SessionFactory sessionFactory) {
//                super.setSessionFactory(sessionFactory);
//        }



        public Session getSession(){
                return sessionFactory.getCurrentSession();
        }

        private Class clazz;//用于接收运行期泛型类型
        public BaseDaoImpl(){
                //获得当前类型的带有泛型类型的父类
                ParameterizedType typeClazz =  (ParameterizedType) this.getClass().getGenericSuperclass();
                clazz = (Class) typeClazz.getActualTypeArguments()[0];//获得运行的泛型类型
        }

        public void save(T t) {
//                super.getHibernateTemplate().setCheckWriteOperations(false);
                super.getHibernateTemplate().save(t);
//                super.getHibernateTemplate().save()
        }

        public void delete(Integer id) {
                super.getHibernateTemplate().delete(id);
        }

        public void delete(T t) {
                super.getHibernateTemplate().delete(t);
        }

        public void update(T t) {
                super.getHibernateTemplate().update(t);
        }

        public T getById(Integer id) {

        return (T) getHibernateTemplate().get(clazz, id);

        }

        public Integer getTotalCount(DetachedCriteria dc) {
                //设置聚合函数，查数量
                dc.setProjection(Projections.rowCount());
                List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc);
                //清空聚合函数，防止影响其他查询结果
                dc.setProjection(null);
                if(list!=null&&list.size()>0){
                        return (Integer) list.get(0);
                }else{
                        return null;
                }
        }

        public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
                        //start 从第几条数据开始查
                        return (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
        }
//
//        public List<T> findAll(T entity) {
//                // TODO Auto-generated method stub
//                return getSession().createQuery("FROM "+clazz.getSimpleName()).list();
//        }




}