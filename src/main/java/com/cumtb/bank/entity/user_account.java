package com.cumtb.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_account")
@Entity
public class user_account {
    @Id
    private Integer uid;
    @Id
    private Integer cid;

    public user_account() {
    }

    public user_account(Integer uid, Integer cid) {
        this.uid = uid;
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
