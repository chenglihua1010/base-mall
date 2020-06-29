package com.pumpkin.controller;

import com.pumpkin.entity.Order;
import com.pumpkin.entity.Transport;
import com.pumpkin.entity.User;
import com.pumpkin.service.impl.TransportImpl;
import com.pumpkin.service.impl.UserImpl;
import com.pumpkin.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/transport")
public class TransportController {
        private TransportImpl transportImpl;
        private UserImpl userImpl;

        @Resource(name = "userImpl")
        public void setUserImpl(UserImpl userImpl) {
                this.userImpl = userImpl;
        }

        public TransportImpl getTransportImpl() {
                return transportImpl;
        }
        //写在set上
        @Resource(name = "transportImpl")
        public void setTransportImpl(TransportImpl transportImpl) {
                this.transportImpl = transportImpl;
        }

        @RequestMapping("/addTransport")
        public ModelAndView addTransport(HttpServletRequest request){
                //获得数据(传输,页面填写,生成)并向数据库更新数据;向下个页面传输数据(user,transport)
                ModelAndView modelAndView=new ModelAndView();
//                ModelAndView modelAndView=new ModelAndView("success");
                String busId=request.getParameter("busId");
                //通过busId找到accountId, 再定位user
                //通过accountId定位user
                //??
                String accountId=request.getParameter("accountId");
                List<User> userList=userImpl.findByAccountId(accountId);


                //??
                String goodsId=request.getParameter("goodsId");
                String goodsName=request.getParameter("goodsName");
                String pay=request.getParameter("pay");
                Integer payInt=Integer.parseInt(pay);

                Order order=new Order();
                order.setBusId(busId);
                order.setGoodsId(goodsId);
                order.setGoodsName(goodsName);
                order.setAccountId(accountId);
                order.setPay(payInt);
//                Integer status=1;
                String type=request.getParameter("type");
                Integer typeInt=Integer.parseInt(type);
                Transport transport=new Transport();
                String createTime=request.getParameter("createTime");
//                Date date=Date.parse(createTime);
                //更新Order pay
                transport.setBusId(busId);
//                transport.setStatus(status);
                transport.setType(typeInt);
                try{
                        transport.setArrivalTime(DateUtil.getAfterThreeDay(new Date()));
                }catch (Exception e){
                        e.printStackTrace();
                }
                transport.setCreateTime(new Date());

                transportImpl.add(transport);

                modelAndView.addObject("transprot",transport);
                //?
                modelAndView.addObject("userList",userList.get(0));
                modelAndView.addObject("order",order);
                modelAndView.setViewName("success");

                return modelAndView;
        }
}