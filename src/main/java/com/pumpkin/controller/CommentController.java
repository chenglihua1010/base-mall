package com.pumpkin.controller;

import com.pumpkin.entity.Comment;
import com.pumpkin.entity.Order;
import com.pumpkin.entity.Transport;
import com.pumpkin.service.impl.CommentImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController {

        private CommentImpl commentImpl;

        public CommentImpl getCommentImpl() {
                return commentImpl;
        }
@Resource(name = "commentImpl")
        public void setCommentImpl(CommentImpl commentImpl) {
                this.commentImpl = commentImpl;
        }
        @RequestMapping("/addComment")
        public ModelAndView addComment(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                Comment comment=new Comment();
                //不能new个新的对象，通过busId(唯一，共有的)找到对象，再更新(set-update)
//                Order order=new Order();
//                Transport transport=new Transport();
//                Integer orderStatusInt=Integer.parseInt(orderStatus);
//                Integer transportStatusInt=Integer.parseInt(transportStatus);
//                order.setPay(orderStatusInt);
//                transport.setStatus(transportStatusInt);

                //test
//                    comment.setBusId("qwe");
//                comment.setType(1);
                String busId=request.getParameter("busId");
                String accountId=request.getParameter("accountId");
                String commentText=request.getParameter("commentText");
                String goodsName=request.getParameter("goodsName");
                String goodsId=request.getParameter("goodsId");
                String orderStatus=request.getParameter("orderStatus");
                String transportStatus=request.getParameter("transportStatus");
                String typeComment=request.getParameter("typeComment");
                Integer typeCommentInt=Integer.parseInt(typeComment);

                comment.setBusId(busId);
                comment.setAccountId(accountId);
                comment.setCommentText(commentText);
                comment.setCreateTime(new Date());
                comment.setGoodsName(goodsName);
                comment.setGoodsId(goodsId);
                //如何自动获取评价类型(支付方式,物流状态,物流公司选择)-下拉框
                comment.setType(typeCommentInt);

                commentImpl.add(comment);


                return modelAndView;
        }

        //更新success.jsp
}