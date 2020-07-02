package com.pumpkin.controller;

import com.pumpkin.entity.Integral;
import com.pumpkin.entity.Merchandise;
import com.pumpkin.entity.User;
import com.pumpkin.entity.Vip;
import com.pumpkin.service.impl.IntegralImpl;
import com.pumpkin.service.impl.MerchandiseImpl;
import com.pumpkin.service.impl.UserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

        private UserImpl userImpl;
        private IntegralImpl integralImpl;

        @Resource(name = "integralImpl")
        public void setIntegralImpl(IntegralImpl integralImpl) {
                this.integralImpl = integralImpl;
        }


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







        private static List<User> userList;
        {
                userList=new ArrayList<User>();
        }

        /*
        注册页面：register.jsp
         */


        @RequestMapping("/showReUser")
        public String showReUser(){
                return "register";
        }

        //注册的数据传到addUser？？
        //method = RequestMethod.GET/POST???

        @RequestMapping("/addUser")
//        public String addUser(
//                @RequestParam("accountId")String accountId,
//                @RequestParam("password")String password,
//                @RequestParam("name")String name){
//                User user=new User();
        public String addUser(HttpServletRequest request){
                User user=new User();
                String accountId=request.getParameter("accountId");
                String password=request.getParameter("password");
                String name=request.getParameter("name");
                String viplevel=request.getParameter("viplevel");
                Integer viplevelInt=Integer.parseInt(viplevel);
                String duration=request.getParameter("duration");
                Integer durationInt=Integer.parseInt(duration);


                user.setAccountId(accountId);
                user.setPassword(password);
                user.setName(name);
                //生成积分
                Integral integral=new Integral();
                integral.setAccountId(accountId);
                integral.setTotal(0);
                integral.setStatus(2);
                integralImpl.addIntegral(integral);
                //生成会员
                Vip vip=new Vip();
                vip.setAcountId(accountId);
                vip.setDuration(durationInt);
                vip.setCreateTime(new Date());

                userImpl.add(user);
                return "/login";
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
                        modelAndView.addObject("merchandiseList",merchandiseList);

                        //商品销售排行榜
                        List<Merchandise> merchandiseListForRank=merchandiseImpl.rankByCount();
                        modelAndView.addObject("merchandiseListForRank",merchandiseListForRank);
//                        modelAndView.addObject("merchandise0",merchandiseList.get(0));
//                        modelAndView.addObject("merchandise1",merchandiseList.get(1));
//                        modelAndView.addObject("merchandise2",merchandiseList.get(2));
//                        modelAndView.addObject("merchandise3",merchandiseList.get(3));
//                        modelAndView.addObject("merchandise4",merchandiseList.get(4));
                }

                return modelAndView;
        }

        public User getUserByAccountIDAndPsw(String accountId, String password){
                User user=new User();
                user=userImpl.getUserByAccountIdAndPsw(accountId,password);
                return user;
        }

        public User findByBusId(String busId){
                return userImpl.findByBusId(busId);
        }
}