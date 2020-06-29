package com.pumpkin.dao.impl;

import com.pumpkin.dao.BaseDao;
import com.pumpkin.dao.CommentDao;
import com.pumpkin.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentDaoImpl")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{



        public void add(Comment comment){
                save(comment);
        }
}