package com.pumpkin.controller;

import com.pumpkin.entity.Merchandise;
import com.pumpkin.service.impl.MerchandiseImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

        private MerchandiseImpl merchandiseImpl;


        @Resource(name = "merchandiseImpl")
        public void setMerchandiseImpl(MerchandiseImpl merchandiseImpl) {
                this.merchandiseImpl = merchandiseImpl;
        }

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

        @RequestMapping(value = "/list")
        public String list(String communityId){
                if(communityId==null){
                        return "error";
                }else {
                        return "login";
                }
        }

        @RequestMapping(value = "/tolist")
        public String test(Integer number){
                if(number==0){
                        return "error";
                }else{
                        return "login";
                }
        }




        @RequestMapping(value = "/findAllpumpkin")
        public ModelAndView findAllpumpkin(){
                List<Merchandise> merchandiseList= merchandiseImpl.findAllpumpkin();
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.addObject(merchandiseList.get(0).getGoodsName(),"merchandiseList");//
                //写一个页面，返回的值显示在前端页面上面
                modelAndView.setViewName("index");
                return modelAndView;

        }
//根据名字获取南瓜信息，并将信息返回至页面



}