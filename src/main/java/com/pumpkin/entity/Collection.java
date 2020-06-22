package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_collection" )
public class Collection implements Serializable{
        private static final long serialVersionUID = 2332067275497753721L;

       //id = "主键id"
        private Integer id;
        //goodsId = "商品id"
        private String goodsId;
        //goodsName = "商品名称"
        private String goodsName;
        //account= "账号"
        private String accountId;
        //createTime= "收藏时间"
        private Date createTime;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",unique = true,nullable = false,length = 11)
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name="goodsId")
        public String getGoodsId() {
                return goodsId;
        }

        public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
        }
        @Column(name = "goodsName")
        public String getGoodsName() {
                return goodsName;
        }

        public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
        }
        @Column(name="accountId")
        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
        }
        @Column(name ="createTime")
        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }
}