package com.cumtb.bank.entity.User;

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

    public User() {
    }

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
