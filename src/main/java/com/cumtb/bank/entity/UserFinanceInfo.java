package com.cumtb.bank.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "user_finance")
@Entity
public class UserFinanceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;
    private Integer uid;
    private Integer cid;
    private Integer fid;
    private Float money;
    private Timestamp starttime;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }
}
