package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_transport")
public class Transport implements Serializable{
        private static final long serialVersionUID = 2222067775497753721L;
        private Integer id;
        private String busId;
        private Integer status;
        private Date createTime;
        private Date arrivalTime;
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
        @Column(name = "busId")
        public String getBusId() {
                return busId;
        }

        public void setBusId(String busId) {
                this.busId = busId;
        }
        @Column(name = "status")
        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }
        @Column(name = "createTime")
        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }
        @Column(name = "arrivalTime")
        public Date getArrivalTime() {
                return arrivalTime;
        }
        @Column(name = "type")
        public Integer getType() {
                return type;
        }

        public void setType(Integer type) {
                this.type = type;
        }

        public void setArrivalTime(Date arrivalTime) {
                this.arrivalTime = arrivalTime;
        }
}