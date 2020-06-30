package com.pumpkin.controller;

import com.pumpkin.entity.Integral;
import com.pumpkin.service.impl.IntegralImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/integral" )
public class IntegralController {
        private IntegralImpl integralImpl;

        @Resource(name = "integralImpl")
        public void setIntegralImpl(IntegralImpl integralImpl) {
                this.integralImpl = integralImpl;
        }

        @RequestMapping("/addIntegral")
        public Integral addIntegral(){
                Integral integral=new Integral();
                integralImpl.addIntegral(integral);
                return integral;
        }
}