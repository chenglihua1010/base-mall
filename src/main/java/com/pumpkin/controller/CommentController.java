package com.pumpkin.controller;

import com.pumpkin.entity.Comment;
import com.pumpkin.service.impl.CommentImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
                //test
                comment.setBusId("qwe");
                comment.setType(1);



                commentImpl.add(comment);

                return modelAndView;
        }

        //更新success.jsp
}