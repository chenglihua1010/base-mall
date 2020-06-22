package com.pumpkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {

        @RequestMapping("/toIndex")
        public String goToIndexHtml(Integer in){
                return "index3";
        }
//尝试访问views index2.jsp  访问不到
        @RequestMapping("/toIndexs")
        public String geToIndex2JSP(){
                return "index2";
        }

        @RequestMapping("/toError")
        public String goToEeeor(){
                return "error";
        }
        @RequestMapping("/toLogin")
        public String goToLogin(){
                return "login";
        }

        //返回值 加上@ResponseBody注解
        @RequestMapping("/toString")
        @ResponseBody
        public String goToString(){
                return "woshiString";
        }



        //TODO redirect 重定位（方法、String:url）
        @RequestMapping("/toRedirect")
        public String goToRedirect(){
                return "redirect:toString";
        }
        @RequestMapping("/toRedirects")
        public String goToRedirect2(){
                return "redirect:http://localhost:8080/index/toLogin";
        }
        @RequestMapping("/toRedirectss")
        public String goToRedirectss(){
                return "redirect:/index/toLogin";
        }




//        @RequestMapping("/getString")
//        public String getString(){
//                //方法不进行跳转，只进行查询值并返回
//        }


        //写一个成功页面，登录成功。login.jsp  errorLogin.jsp
        //写一个方法，成功的时候跳转哪个，失败的时候跳转哪一个
        //cetitijao1




}