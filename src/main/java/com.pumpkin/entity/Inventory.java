package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_inventory")
public class Inventory implements Serializable{
        private static final long serialVersionUID = 2332067275497753721L;
        private Integer id;
        private String goodsId;
        private String goodsName;
        private Integer count;
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
        @Column(name = "count")
        public Integer getCount() {
                return count;
        }

        public void setCount(Integer count) {
                this.count = count;
        }
        @Column(name = "goodsName")
        public String getGoodsName() {
                return goodsName;
        }

        public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
        }
}