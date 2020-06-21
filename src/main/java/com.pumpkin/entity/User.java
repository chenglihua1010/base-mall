package com.pumpkin.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "base_user")
public class User implements Serializable{
        private static final long serialVersionUID = 2322067775497753721L;
        private Integer id;
        private String accountId;
        private String password;
        private Integer phone;
        private String vCode;
        private String addresss;
        private String name;
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
        public String getAccountId() {
                return accountId;
        }

        public void setAccountId(String accountId) {
                this.accountId = accountId;
        }
        @Column(name = "password")
        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
        @Column(name = "phone")
        public Integer getPhone() {
                return phone;
        }

        public void setPhone(Integer phone) {
                this.phone = phone;
        }
        @Column(name = "vCode")
        public String getvCode() {
                return vCode;
        }

        public void setvCode(String vCode) {
                this.vCode = vCode;
        }
        @Column(name = "address")
        public String getAddresss() {
                return addresss;
        }

        public void setAddresss(String addresss) {
                this.addresss = addresss;
        }
        @Column(name = "name")
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}