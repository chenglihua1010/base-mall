package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_order")
public class Order implements Serializable{
        private static final long serialVersionUID = 2332067275497752721L;
        private Integer id;

        private String busId;
        private String accountId;//

        private String goodsId;
        private String goodsName;
        private Integer count;
        private Double allPrice;
        private String address;
        private Integer phone;
        private Integer pay;
        private Date createTime;
        private Integer status;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",unique = true,nullable = false,length = 11)
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "busId")
        public String getBusId() {
                return busId;
        }

        public void setBusId(String busId) {
                this.busId = busId;
        }
        @Column(name = "accountId")
        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
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
        @Column(name = "[count]")
        public Integer getCount() {
                return count;
        }

        public void setCount(Integer count) {
                this.count = count;
        }

        @Column(name = "allPrice")
        public Double getAllPrice() {
                return allPrice;
        }

        public void setAllPrice(Double allPrice) {
                this.allPrice = allPrice;
        }



        @Column(name = "address")
        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }
        @Column(name = "phone")
        public Integer getPhone() {
                return phone;
        }

        public void setPhone(Integer phone) {
                this.phone = phone;
        }
        @Column(name = "createTime")
        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        @Column(name = "pay")
        public Integer getPay() {
                return pay;
        }

        public void setPay(Integer pay) {
                this.pay = pay;
        }
        @Column(name = "status")
        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }
}