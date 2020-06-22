package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_vip")
public class Vip implements Serializable{
        private static final long serialVersion = 2332067775497753721L;
        private Integer id;
        private String acountId;
        private Integer viplevel;
        private Integer vipName;
        private String discount;
        private Integer duration;
        private Date createTime;
        private Date endTime;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",unique = true,nullable = false,length = 11)
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "accountId")
        public String getAcountId() {
                return acountId;
        }

        public void setAcountId(String acountId) {
                this.acountId = acountId;
        }
        @Column(name = "viplevel")
        public Integer getViplevel() {
                return viplevel;
        }

        public void setViplevel(Integer viplevel) {
                this.viplevel = viplevel;
        }
        @Column(name = "vipName")
        public Integer getVipName() {
                return vipName;
        }

        public void setVipName(Integer vipName) {
                this.vipName = vipName;
        }
        @Column(name = "discount")
        public String getDiscount() {
                return discount;
        }

        public void setDiscount(String discount) {
                this.discount = discount;
        }
        @Column(name = "duration")
        public Integer getDuration() {
                return duration;
        }

        public void setDuration(Integer duration) {
                this.duration = duration;
        }
        @Column(name = "createTime")
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
}