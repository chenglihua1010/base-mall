package com.pumpkin.controller;

import com.pumpkin.entity.Merchandise;
import com.pumpkin.entity.Order;
import com.pumpkin.service.impl.MerchandiseImpl;
import com.pumpkin.service.impl.OrderImpl;
import com.pumpkin.util.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

        private OrderImpl orderImpl;
        private MerchandiseImpl merchandiseImpl;

        @Resource(name = "merchandiseImpl")
        public void setMerchandiseImpl(MerchandiseImpl merchandiseImpl) {
                this.merchandiseImpl = merchandiseImpl;
        }

        @Resource(name = "orderImpl")
        public void setOrderImpl(OrderImpl orderImpl) {
                this.orderImpl = orderImpl;
        }


        //创建订单，并进入订单支付页面
        @RequestMapping("/addOrder")
        public ModelAndView add(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String busId=RandomUtil.getRandomNickname(10);
                String goodsName=request.getParameter("goodsName");
                String goodsId=request.getParameter("goodsId");
                String goodsPrice=request.getParameter("goodsPrice");
                Double goodsPriceDouble=Double.parseDouble(goodsPrice);
                String count=request.getParameter("quantity");
                Integer countInt=Integer.parseInt(count);

                //更新库存，购买量
                List<Merchandise> merchandiseList=merchandiseImpl.findByGn(goodsName);
                merchandiseList.get(0).setPurchaseCount(merchandiseList.get(0).getPurchaseCount()+countInt);
                merchandiseList.get(0).setInventory(merchandiseList.get(0).getInventory()-countInt);
                merchandiseImpl.updateMerchandise(merchandiseList.get(0));



                Double allPrice=countInt*goodsPriceDouble;
                String accountId=request.getParameter("accountId");
                String phone=request.getParameter("phone");
                Integer phoneInteger=Integer.parseInt(phone);
                String address=request.getParameter("address");

//                List<Merchandise> merchandiseList=merchandiseImpl.findByGn(goodsName);


                //积分
//                String integral=request.getParameter("integral");
//                Integer integralInt=Integer.parseInt(integral);

                String size=request.getParameter("size");

                Order order=new Order();
                order.setGoodsName(goodsName);
                order.setGoodsId(goodsId);
                order.setAllPrice(allPrice);
                order.setCount(countInt);
                order.setCreateTime(new Date());
                order.setStatus(1);
                order.setAccountId(accountId);
                order.setBusId(busId);
                order.setPhone(phoneInteger);
                order.setAddress(address);
                orderImpl.add(order);
                //??
                modelAndView.addObject("order",order);
                modelAndView.addObject("merchandise",merchandiseList.get(0));
                modelAndView.setViewName("payment");
                return modelAndView;
        }
}