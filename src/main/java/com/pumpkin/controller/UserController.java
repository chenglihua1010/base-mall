package com.pumpkin.controller;

import com.pumpkin.entity.Merchandise;
import com.pumpkin.entity.User;
import com.pumpkin.service.impl.MerchandiseImpl;
import com.pumpkin.service.impl.UserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

        private UserImpl userImpl;
        @Resource(name="userImpl")
        public void setUserImpl(UserImpl userImpl) {
                this.userImpl = userImpl;
        }

        @Resource(name="merchandiseImpl")
        private MerchandiseImpl merchandiseImpl;

        public MerchandiseImpl getMerchandiseImpl() {
                return merchandiseImpl;
        }

        public void setMerchandiseImpl(MerchandiseImpl merchandiseImpl) {
                this.merchandiseImpl = merchandiseImpl;
        }

        public UserImpl getUserImpl() {
                return userImpl;
        }

        @RequestMapping("/toLogin")
        public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response){
                ModelAndView modelAndView=new ModelAndView();
                String accountId=request.getParameter("accountId");
                String password=request.getParameter("password");
                User user=this.getUserByAccountIDAndPsw(accountId,password);
                if(null==user){
                        modelAndView.setViewName("error");
                }else{
                        modelAndView.setViewName("index");
                        modelAndView.addObject("user",user);

                        List<Merchandise> merchandiseList= merchandiseImpl.findAllpumpkin();
                        modelAndView.addObject("merchandise",merchandiseList.get(0));
                }




                return modelAndView;
        }

        public User getUserByAccountIDAndPsw(String accountId, String password){
                User user=new User();
                user=userImpl.getUserByAccountIdAndPsw(accountId,password);
                return user;
        }
}