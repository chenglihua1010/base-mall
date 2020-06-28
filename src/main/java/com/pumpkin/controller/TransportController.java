package com.pumpkin.controller;

import com.pumpkin.entity.Transport;
import com.pumpkin.service.impl.TransportImpl;
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

                Transport transport=new Transport();
                String createTime=request.getParameter("createTime");

                transport.setBusId(busId);
                //transport.setCreateTime();
                //santianhou
                transportImpl.add(transport);

                modelAndView.setViewName("successs");

                return modelAndView;
        }
}