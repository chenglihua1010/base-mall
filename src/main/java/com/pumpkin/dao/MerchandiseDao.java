package com.pumpkin.dao;

import com.pumpkin.entity.Merchandise;

import java.util.List;

public interface MerchandiseDao extends BaseDao<Merchandise>{
         List<Merchandise> findAllpumpkin();
}