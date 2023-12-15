package com.cumtb.bank.controller;

import com.cumtb.bank.entity.Loan;
import com.cumtb.bank.entity.Result;
import com.cumtb.bank.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Resource
    private LoanService loanService;

    /**
     * 贷款查询接口
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param type 贷款类型
     * @param state 贷款状态
     * @return
     * ps:cid/type/state只能有一个不为0
     * */
    @PostMapping("/query")
    public Result query(Integer uid,Integer cid,Integer type,Integer state){
        List<Loan> loanList=loanService.queryService(uid, cid, type, state);
        if(loanList!=null){
            return Result.ok("查询成功!",loanList);
        }else{
            return Result.ok("无相关记录");
        }
    }
}
