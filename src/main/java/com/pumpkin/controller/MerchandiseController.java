package com.pumpkin.controller;

import com.pumpkin.entity.Merchandise;
import com.pumpkin.service.impl.MerchandiseImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {
        private MerchandiseImpl merchandiseImpl;
        @Resource(name = "merchandiseImpl")
        public void setMerchandiseImpl(MerchandiseImpl merchandiseImpl) {
                this.merchandiseImpl = merchandiseImpl;
        }

        /**
         * 商品搜索
         * @param request
         * @return 所得商品信息页面
         */
        @RequestMapping("/merchandiseInfor")
        public ModelAndView findByParam(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView("merchandiseInfor");
                String goodsName=request.getParameter("goodsName");
                String origin=request.getParameter("origin");
                Merchandise merchandise=merchandiseImpl.findByParam(goodsName,origin);
                modelAndView.addObject("merchandise",merchandise);
                return modelAndView;


        }
}