package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_comment")
public class Comment implements Serializable{
        private static final long serialVersionUID = 2332067275497453721L;
        private Integer id;
        private String busId;
        private String goodsId;
        private String goodsName;
        private String accountId;
        private String imgs;
        private Date createTime;
        private Integer type;



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",unique = true,nullable = false,length = 11)
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "busID")
        public String getBusId() {
                return busId;
        }

        public void setBusId(String busId) {
                this.busId = busId;
        }
        @Column(name = "goodsId")
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
        @Column(name = "accountId")
        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
        }
        @Column(name = "imgs")
        public String getImgs() {
                return imgs;
        }

        public void setImgs(String imgs) {
                this.imgs = imgs;
        }
        @Column(name = "createTime")
        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }
        @Column(name = "type")
        public Integer getType() {
                return type;
        }

        public void setType(Integer type) {
                this.type = type;
        }
}