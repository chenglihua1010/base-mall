package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_integral")
public class Integral implements Serializable{
        private static final long serialVersionUID = 2332047275497753721L;
        private Integer id;
        private String accountId;
        private Integer total;
        private Integer status;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name = "id",unique = true,nullable = false,length = 11)
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "accountId")
        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
        }
        @Column(name = "total")
        public Integer getTotal() {
                return total;
        }

        public void setTotal(Integer total) {
                this.total = total;
        }
        @Column(name = "status")
        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }
}