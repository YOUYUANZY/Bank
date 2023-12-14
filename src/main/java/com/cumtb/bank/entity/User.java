package com.cumtb.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private int uid;//用户标识
    private String name;//用户姓名
    private String id;//身份证号
    private String phone;//手机号
    private String question;//密保问题
    private String answer;//密保答案
    private String password;//登录密码
    private String address;//住址
    public User(){}
    public User(int uid, String name, String id, String phone, String question, String answer, String password, String address) {
        this.uid = uid;
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.password = password;
        this.address = address;
    }
}
