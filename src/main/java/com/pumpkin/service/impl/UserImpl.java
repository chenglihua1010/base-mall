package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.UserDaoImpl;
import com.pumpkin.entity.User;
import com.pumpkin.service.UserInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("userImpl")
public class UserImpl implements UserInterface{

        public UserDaoImpl userDaoimpl;
        @Resource(name = "userDaoImpl")
        public void setUserDaoimpl(UserDaoImpl userDaoimpl) {
                this.userDaoimpl = userDaoimpl;
        }

        public User getUserByAccountIdAndPsw(String accountId, String password){
                User user=new User();
                user=userDaoimpl.getUserByAccountIdAndPsw(accountId,password);
                return user;
        }
}