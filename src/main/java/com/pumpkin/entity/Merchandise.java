package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_merchandise")
public class Merchandise implements Serializable{
        private static final long serialVersionUID = 2222067775497754729L;
        private Integer id;
        private String goodsId;
        private String goodsName;
        private Integer inventory;
        private String imgs;
        private String describe;
        private Integer evacount;
        private Integer purchaseCount;
        private String origin;
        private Double goodsPrice;
        private String size;


        @Column
        public String getSize() {
                return size;
        }

        public void setSize(String size) {
                this.size = size;
        }

        @Column(name = "goodsPrice")
        public Double getGoodsPrice() {
                return goodsPrice;
        }

        public void setGoodsPrice(Double goodsPrice) {
                this.goodsPrice = goodsPrice;
        }


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",unique = true,nullable = false,length = 11)
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
        @Column(name = "imgs")
        public String getImgs() {
                return imgs;
        }

        public void setImgs(String imgs) {
                this.imgs = imgs;
        }
        @Column(name = "inventory")
        public Integer getInventory() {
                return inventory;
        }

        public void setInventory(Integer inventory) {
                this.inventory = inventory;
        }
        @Column(name = "[describe]")
        public String getDescribe() {
                return describe;
        }

        public void setDescribe(String describe) {
                this.describe = describe;
        }





        @Column(name = "evacount")
        public Integer getEvacount() {
                return evacount;
        }

        public void setEvacount(Integer evacount) {
                this.evacount = evacount;
        }
        @Column(name = "purchaseCount")
        public Integer getPurchaseCount() {
                return purchaseCount;
        }

        public void setPurchaseCount(Integer purchaseCount) {
                this.purchaseCount = purchaseCount;
        }
        @Column(name = "origin")
        public String getOrigin() {
                return origin;
        }

        public void setOrigin(String origin) {
                this.origin = origin;
        }
}