package com.cumtb.bank.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tradeinfo")
@Entity
public class TradeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid; // 交易记录流水号
    private String fromName; // 转出方姓名
    private String fromCard; // 转出方卡号
    private String toName; // 转入方姓名
    private String toCard; // 转入方卡号
    private float money; // 交易金额
    private LocalDateTime time; // 交易时间
    private int type; // 交易类型

    public TradeInfo() {
    }

    public TradeInfo(int tid, String fromName, String fromCard, String toName, String toCard, float money, LocalDateTime time, int type) {
        this.tid = tid;
        this.fromName = fromName;
        this.fromCard = fromCard;
        this.toName = toName;
        this.toCard = toCard;
        this.money = money;
        this.time = time;
        this.type = type;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromCard() {
        return fromCard;
    }

    public void setFromCard(String fromCard) {
        this.fromCard = fromCard;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToCard() {
        return toCard;
    }

    public void setToCard(String toCard) {
        this.toCard = toCard;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
