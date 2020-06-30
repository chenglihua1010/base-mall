package com.pumpkin.dao.impl;

import com.pumpkin.dao.TimingDao;
import com.pumpkin.entity.Timing;
import org.springframework.stereotype.Repository;

@Repository("timingDaoImpl")
public class TimingDaoImpl extends BaseDaoImpl<Timing> implements TimingDao{

}