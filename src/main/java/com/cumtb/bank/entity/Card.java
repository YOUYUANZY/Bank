package com.cumtb.bank.entity;

import javax.persistence.*;

@Table(name = "card")
@Entity
public class Card{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cardID;
    private String password;
    private Integer state;
    private Integer type;

    public Card() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Card(Integer cid, String cardID, String password, Integer state, Integer type) {
        this.cid = cid;
        this.cardID = cardID;
        this.password = password;
        this.state = state;
        this.type = type;
    }
}
