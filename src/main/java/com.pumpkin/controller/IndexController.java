package com.pumpkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

        @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
        public String goToIndexHtml(){
                return "index";
        }

}