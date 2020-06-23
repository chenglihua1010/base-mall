package com.pumpkin.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BaseDao<T> {
        //增
        void save(T t);
        //根据id删
        void delete (Integer id);
        //根据对象删
        void delete(T t);
        //改
        void update (T t);
        //根据id查询
        T getById(Integer id);
        //查询总数
        Integer getTotalCount(DetachedCriteria dc);
        //查询分页数据，返回对象的集合
        List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

//        //查询所有
//         List<T> findAll(T entity);


}