package com.pumpkin.controller;

import com.pumpkin.entity.Transport;
import com.pumpkin.service.impl.TransportImpl;
import com.pumpkin.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/transport")
public class TransportController {
        private TransportImpl transportImpl;


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
                ModelAndView modelAndView=new ModelAndView();
//                ModelAndView modelAndView=new ModelAndView("success");
                String busId=request.getParameter("busId");
                Integer status=1;
                String type=request.getParameter("type");
                Integer typeInt=Integer.parseInt(type);
                Transport transport=new Transport();
                String createTime=request.getParameter("createTime");
//                Date date=Date.parse(createTime);
                //更新Order pay
                transport.setBusId(busId);
                transport.setStatus(status);
                transport.setType(typeInt);
                try{
                        transport.setArrivalTime(DateUtil.getAfterThreeDay(new Date()));
                }catch (Exception e){
                        e.printStackTrace();
                }


                transport.setCreateTime(new Date());


                //santianhou
                transportImpl.add(transport);

                modelAndView.setViewName("success");

                return modelAndView;
        }
}