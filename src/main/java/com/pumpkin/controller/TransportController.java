package com.pumpkin.controller;

import com.pumpkin.entity.Integral;
import com.pumpkin.entity.Order;
import com.pumpkin.entity.Transport;
import com.pumpkin.entity.User;
import com.pumpkin.service.impl.IntegralImpl;
import com.pumpkin.service.impl.OrderImpl;
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
        private OrderImpl orderImpl;
        private IntegralImpl integralImpl;

        @Resource(name = "integralImpl")
        public void setIntegralImpl(IntegralImpl integralImpl) {
                this.integralImpl = integralImpl;
        }

        @Resource(name = "orderImpl")
        public void setOrderImpl(OrderImpl orderImpl) {
                this.orderImpl = orderImpl;
        }

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
                String accountId=request.getParameter("accountId");
//                List<User> userList=userImpl.findByAccountId(accountId);

                Integral integral=integralImpl.findByAccountId(accountId);
                String score=request.getParameter("score");
                Integer integralInt=Integer.parseInt(score);
                //当前+本次订单所得
                integral.setTotal(integral.getTotal()+integralInt);
                //更新积分
                integralImpl.updateIntegral(integral);


                //??以存在的值,下步还有用, 还需set进去?
//                String goodsId=request.getParameter("goodsId");
//                String goodsName=request.getParameter("goodsName");
                //更新order的pay
                Order order=orderImpl.findByBusId(busId);
                String pay=request.getParameter("pay");
                Integer payInt=Integer.parseInt(pay);
                order.setPay(payInt);
                orderImpl.updateOrder(order);

//                order.setBusId(busId);
//                order.setGoodsId(goodsId);
//                order.setGoodsName(goodsName);
//                order.setAccountId(accountId);

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
                transport.setStatus(1);
                transportImpl.add(transport);

                modelAndView.addObject("transprot",transport);
                //?
//                modelAndView.addObject("userList",userList.get(0));
                //用途范围,可以理解添加一个名为""的类,可以用类中的所有内容?
                modelAndView.addObject("order",order);
                modelAndView.setViewName("success");

                return modelAndView;
        }
}