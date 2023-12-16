package com.cumtb.bank.controller;

import com.cumtb.bank.entity.Card;
import com.cumtb.bank.entity.UserFinanceInfo;
import com.cumtb.bank.service.AccountService;
import com.cumtb.bank.service.FinanceService;
import com.cumtb.bank.utils.Result;
import com.cumtb.bank.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    /**
     * 开户
     * @param uid 用户标识
     *
     * @return
     * */
    @RequestMapping("/create")
    public Result CreateAccount(@RequestBody Card card, @RequestParam Integer uid){
            if(accountService.CreateCard(card,uid)==null){
                return Result.err(Result.CODE_ERR_BUSINESS,"创建失败");
            }
            return Result.ok("创建成功",card);
    }
    //取款
    @RequestMapping("/withdrawal")
    public Result withdrawal(@RequestParam Integer cid, @RequestParam float money){
        if(!accountService.withdrawal(cid, money)){
            return Result.err(Result.CODE_ERR_BUSINESS,"取款失败");
        }
        return Result.ok("取款成功");
    }
    //活期存款
    @RequestMapping("/current deposit")
    public Result current_deposit(@RequestParam Integer cid, @RequestParam float money){
        if(!accountService.current_deposit(cid, money)){
            return Result.err(Result.CODE_ERR_BUSINESS,"存款失败");
        }
        return Result.ok("存款成功");
    }
}
