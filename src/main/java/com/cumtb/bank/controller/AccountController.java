package com.cumtb.bank.controller;

import com.cumtb.bank.entity.*;
import com.cumtb.bank.service.AccountService;
import com.cumtb.bank.service.FinanceService;
import com.cumtb.bank.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    //开户
    @RequestMapping("/create")
    public Result CreateAccount(@RequestBody Card card, @RequestParam Integer uid){
        Card card1=accountService.CreateCard(card,uid);
            if(card1==null){
                return Result.err(Result.CODE_ERR_BUSINESS,"创建失败");
            }
            return Result.ok("创建成功",card1);
    }
    //取款
    @RequestMapping("/withdrawal")
    public Result withdrawal(@RequestParam Integer cid, @RequestParam float money){
        CardActive cardActive=accountService.withdrawal(cid,money);
        if(cardActive==null){
            return Result.err(Result.CODE_ERR_BUSINESS,"取款失败");
        }
        return Result.ok("取款成功",cardActive);
    }
    //活期存款
    @RequestMapping("/current_deposit")
    public Result current_deposit(@RequestParam Integer cid, @RequestParam float money){
        CardActive cardActive=accountService.current_deposit(cid, money);
        if(cardActive==null){
            return Result.err(Result.CODE_ERR_BUSINESS,"存款失败");
        }
        return Result.ok("存款成功",cardActive);
    }
    //转账
    @RequestMapping("/transfer")
    public Result changePassword(@RequestParam String cardid1, @RequestParam String cardid2,float money) {
       TradeInfo tradeInfo=accountService.transfer(cardid1,cardid2,money);
        if(tradeInfo==null){
            return Result.err(Result.CODE_ERR_BUSINESS,"转账失败");
        }
        return Result.ok("转账成功",tradeInfo);
    }
    //查询活期余额
    @RequestMapping("/check_current_Balance")
    public Result check_current(@RequestParam Integer cid) {
        float money=accountService.check(cid);
        if(money<0){
            return Result.err(Result.CODE_ERR_BUSINESS,"查询失败");
        }
        return Result.ok("查询成功",money);
    }

}
