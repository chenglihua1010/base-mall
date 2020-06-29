package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.UserDaoImpl;
import com.pumpkin.entity.User;
import com.pumpkin.service.UserInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("userImpl")
public class UserImpl implements UserInterface{

        public UserDaoImpl userDaoImpl;

        @Resource(name = "userDaoImpl")
        public void setUserDaoimpl(UserDaoImpl userDaoimpl) {
                this.userDaoImpl = userDaoimpl;
        }

        public User getUserByAccountIdAndPsw(String accountId, String password){
                User user=new User();
                user=userDaoImpl.getUserByAccountIdAndPsw(accountId,password);
                return user;
        }

        public User findByAccountId(String accountId){
                return this.userDaoImpl.findByAccountId(accountId);
        }

        public void add(User user){
                userDaoImpl.add(user);
        }

        public User findByBusId(String busId){
                return userDaoImpl.findByBusId(busId);
        }

}