package com.pumpkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

        @RequestMapping("/toIndex")
        public String goToIndexHtml(Integer in){
                return "index3";
        }

//        @RequestMapping("/getString")
//        public String getString(){
//                //方法不进行跳转，只进行查询值并返回
//        }


        //写一个成功页面，登录成功。login.jsp  errorLogin.jsp
        //写一个方法，成功的时候跳转哪个，失败的时候跳转哪一个
        //cetitijao1




}