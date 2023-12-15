package com.cumtb.bank.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  cid;//银行卡标识
    private String cardID;//银行卡号
    private String password;//登录密码
    private int state;//银行卡状态
    private int type;//银行卡类型
    public Card() {
    }

    public Card(int cid, String cardID, String password, int state, int type) {
        this.cid = cid;
        this.cardID = cardID;
        this.password = password;
        this.state = state;
        this.type = type;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
