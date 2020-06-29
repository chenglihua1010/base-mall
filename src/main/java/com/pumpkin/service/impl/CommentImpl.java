package com.pumpkin.service.impl;

import com.pumpkin.dao.impl.CommentDaoImpl;
import com.pumpkin.entity.Comment;
import com.pumpkin.service.CommentInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("commentImpl")
public class CommentImpl implements CommentInterface{
        private CommentDaoImpl commentDaoImpl;

        public CommentDaoImpl getCommentDaoImpl() {
                return commentDaoImpl;
        }
        @Resource(name = "commentDaoImpl")
        public void setCommentDaoImpl(CommentDaoImpl commentDaoImpl) {
                this.commentDaoImpl = commentDaoImpl;
        }

        public void add(Comment comment){
                commentDaoImpl.add(comment);
        }
}