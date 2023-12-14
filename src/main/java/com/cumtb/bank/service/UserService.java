package com.cumtb.bank.service;

import com.cumtb.bank.entity.User;

public interface UserService {
    /**
     * 登录业务
     * @param phone 手机号
     * @param password 密码
     * @return
     * */
    User loginService(String phone,String password);

    /**
     * 注册业务
     * @param user 注册的user对象，uid要为空
     * @return
     * */
    User registerService(User user);
}
