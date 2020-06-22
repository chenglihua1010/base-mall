package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_timing")
public class Timing implements Serializable{
        private static final long serialVersionUID = 2222067775497754721L;
        private Integer id;
        private String goodsId;
        private String goodsName;
        private Date createTime;
        private Date endTime;
        private Integer count;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
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
        @Column(name = "createTime" )
        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }
        @Column(name = "endTime")
        public Date getEndTime() {
                return endTime;
        }

        public void setEndTime(Date endTime) {
                this.endTime = endTime;
        }
        @Column(name = "count")
        public Integer getCount() {
                return count;
        }

        public void setCount(Integer count) {
                this.count = count;
        }
}