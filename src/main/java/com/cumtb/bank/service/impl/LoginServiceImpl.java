package com.cumtb.bank.service.impl;

import com.cumtb.bank.entity.User;
import com.cumtb.bank.repository.UserRepository;
import com.cumtb.bank.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User loginService(String phone, String password) {
        //手机号密码正确则返回用户对象，否则为null
        User user=userRepository.findByPhoneAndPassword(phone,password);
        //重要信息（密码）置空
        if(user!=null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) {
        //当前用户身份已注册
        if(userRepository.findById(user.getId())!=null||userRepository.findByPhone(user.getPhone())!=null){
            return null;
        }else{
            //返回创建好的用户对象（带uid）
            User newUser=userRepository.save(user);
            if(newUser!=null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

    @Override
    public User findBackService(String name, String phone, String id) {
        User user=userRepository.findByNameAndPhoneAndId(name,phone,id);
        if(user!=null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User queryByUid(Integer uid) {
        User user=userRepository.findByUid(uid);
        if(user!=null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User update(User user) {
        User newUser=userRepository.save(user);
        if(newUser!=null){
            newUser.setPassword("");
        }
        return newUser;
    }
}
