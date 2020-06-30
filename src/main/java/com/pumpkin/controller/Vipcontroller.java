package com.pumpkin.controller;

import com.pumpkin.entity.Vip;
import com.pumpkin.service.impl.VipImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/vip")
public class Vipcontroller {
        private VipImpl vipImpl;
        @Resource(name = "vipImpl")
        public void setVipImpl(VipImpl vipImpl) {
                this.vipImpl = vipImpl;
        }

        @RequestMapping("/addVip")
        public ModelAndView addVip(){
                ModelAndView modelAndView=new ModelAndView();
                Vip vip=new Vip();
                
                vipImpl.addVip(vip);
                return modelAndView;
        }

        @RequestMapping("/updateVip")
        public ModelAndView updateVip(){
                ModelAndView modelAndView=new ModelAndView();
                Vip vip=new Vip();

                vipImpl.updateVip(vip);
                return modelAndView;
        }

        @RequestMapping("/findByAccountId")
        public ModelAndView findByAccountId(String accountId){
                ModelAndView modelAndView=new ModelAndView();
                Vip vip=vipImpl.finDByAccountId(accountId);
                return modelAndView;
        }





}