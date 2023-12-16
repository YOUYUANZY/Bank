package com.cumtb.bank.controller;

import com.cumtb.bank.entity.Loan;
import com.cumtb.bank.entity.LoanState;
import com.cumtb.bank.entity.LoanType;
import com.cumtb.bank.entity.Result;
import com.cumtb.bank.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Resource
    private LoanService loanService;
    /**
     * 获取贷款类型接口
     * @param
     * @return
     * */
    @RequestMapping("/loanstate")
    public Result loanState(){
        List<LoanState> loanStateList=loanService.getLoanStateService();
        if(loanStateList!=null){
            return Result.ok("成功获取贷款状态信息!",loanStateList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"贷款状态信息为空或查询错误!");
        }
    }

    /**
     * 贷款查询接口
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param type 贷款类型
     * @param state 贷款状态
     * @return
     * ps:cid/type/state只能有一个不为0
     * */
    @RequestMapping("/query")
    public Result query(@RequestParam Integer uid, @RequestParam Integer cid, @RequestParam Integer type, @RequestParam Integer state){
        List<Loan> loanList=loanService.queryService(uid, cid, type, state);
        if(loanList!=null){
            return Result.ok("查询成功!",loanList);
        }else{
            return Result.ok("无相关记录");
        }
    }

    /**
     * 获取贷款类型接口
     * @param
     * @return
     * */
    @RequestMapping("/loantype")
    public Result loanType(){
        List<LoanType> loanTypeList=loanService.getLoanTypeService();
        if(loanTypeList!=null){
            return Result.ok("成功获取贷款类型信息!",loanTypeList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"贷款类型信息为空或查询错误!");
        }
    }

    /**
     * 办理贷款接口
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param amount 贷款金额
     * @param type 贷款类型
     * @return
     * */
    @RequestMapping("/transact")
    public Result transact(@RequestParam Integer uid,@RequestParam Integer cid,@RequestParam Float amount,@RequestParam Integer type){
        Loan loan=loanService.transactService(uid, cid, amount, type);
        if(loan!=null){
            return Result.ok("申请成功，待审批!",loan);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"申请失败!");
        }
    }
}
