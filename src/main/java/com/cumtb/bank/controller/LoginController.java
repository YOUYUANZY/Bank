package com.cumtb.bank.controller;

import com.cumtb.bank.entity.Result;
import com.cumtb.bank.entity.User;
import com.cumtb.bank.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 登录接口
     * @param phone 手机号
     * @param password 密码
     * @return Result结果
     * */
    @PostMapping("/login")
    public Result login(@RequestParam String phone,@RequestParam String password){
        User user=userService.loginService(phone,password);
        if(user!=null){
            return Result.ok("登录成功!",user);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"账号或密码错误!");
        }
    }

    /**
     * 注册接口
     * @param newUser 用户实例，不带uid
     * @return Result结果
     * */
    @PostMapping("/register")
    public Result register(@RequestBody User newUser){
        User user=userService.registerService(newUser);
        if(user!=null){
            return Result.ok("注册成功!",user);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"该手机号或身份证已注册!");
        }
    }

    /**
     * 找回接口
     * @param name 姓名
     * @param phone 手机号
     * @param id 身份证号
     * @return Result结果
     * */
    @PostMapping("/findBack")
    public Result findBack(@RequestParam String name,@RequestParam String phone,@RequestParam String id){
        User user=userService.findBackService(name,phone,id);
        if(user!=null){
            return Result.ok("存在此用户", new String[]{user.getUid().toString(), user.getQuestion()});
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"身份信息错误!");
        }
    }

    /**
     * 找回—验证接口
     * @param uid 用户内部标识
     * @param answer 密保答案
     * @return Result结果
     * */
    @PostMapping("/findBack/verify")
    public Result verify(@RequestParam Integer uid,@RequestParam String answer){
        User user=userService.queryByUid(uid);
        if(user.getAnswer().equals(answer)){
            return Result.ok("验证成功!");
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"答案错误!");
        }
    }

    /**
     * 找回—修改接口
     * @param uid 用户内部标识
     * @param password 重置密码
     * @param repeatPass 重复密码
     * @return Result结果
     * */
    @PostMapping("/findBack/revise")
    public Result revise(@RequestParam Integer uid,@RequestParam String password,@RequestParam String repeatPass){
        if(password.equals(repeatPass)){
            User user=userService.queryByUid(uid);
            user.setPassword(password);
            User newUser=userService.update(user);
            if(newUser!=null){
                return Result.ok("密码修改成功!");
            }else{
                return Result.err(Result.CODE_ERR_SYS,"用户数据更新失败");
            }
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"两次密码必须一致!");
        }
    }

}
