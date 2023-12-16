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

    /**
     * 密码找回业务
     * @param name 姓名
     * @param phone 手机号
     * @param id 身份证号
     * @return
     * */
    User findBackService(String name,String phone,String id);

    /**
     * uid查找
     * @param uid 用户内部标识
     * @return
     * */
    User queryByUid(Integer uid);

    /**
     * 更新
     * @param user 修改密码user对象，uid不为空
     * @return
     * */
    User update(User user);
}
