package com.cumtb.bank.controller;

import com.cumtb.bank.entity.*;
import com.cumtb.bank.repository.CardActiveRepository;
import com.cumtb.bank.repository.CardRepository;
import com.cumtb.bank.service.FinanceService;
import com.cumtb.bank.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/finance")
public class FinanceController {
    @Resource
    private FinanceService financeService;
    @Resource
    private CardActiveRepository cardActiveRepository;
    @Resource
    private CardRepository cardRepository;

    /**
     * 获取理财产品接口
     * @param type 理财产品类型
     * @return
     * ps:type为0表示获取所有理财产品
     * */
    @RequestMapping("/getfinance")
    public Result getFinance(@RequestParam Integer type){
        List<Finance> financeList=financeService.getFinanceOfService(type);
        if(!financeList.isEmpty()){
            return Result.ok("成功获取理财产品信息!",financeList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"理财产品信息为空或查询错误!");
        }
    }

    /**
     * 获取理财产品类型接口
     * @param
     * @return
     * */
    @RequestMapping("/getfinancetype")
    public Result getFinanceType(){
        List<FinanceType> financeTypeList=financeService.getFinanceTypeService();
        if(!financeTypeList.isEmpty()){
            return Result.ok("成功获取理财产品类型信息!",financeTypeList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"理财产品类型信息为空或查询错误!");
        }
    }

    /**
     * 查询用户理财信息
     * @param uid 用户标识符
     * @param cid 银行卡标识符
     * @param fid 理财产品标识符
     * @return
     * ps:cid/uid只能有一个不为0
     * */
    @RequestMapping("/query")
    public Result query(@RequestParam Integer uid,@RequestParam Integer cid,@RequestParam Integer fid){
        List<UserFinanceInfo> userFinanceInfoList=financeService.queryService(uid, cid, fid);
        if(!userFinanceInfoList.isEmpty()){
            return Result.ok("查询理财信息成功!",userFinanceInfoList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"当前用户理财信息为空或查询错误!");
        }
    }

    /**
     * 投资理财产品
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param fid 理财产品标识
     * @param money 投资金额
     * @param password 银行卡交易密码
     * @return
     * */
    @RequestMapping("/transact")
    public Result transact(Integer uid,Integer cid,Integer fid,Float money,String password){
        Card card=cardRepository.findByCid(cid);
        CardActive cardActive=cardActiveRepository.findByCid(cid);
        if(!card.getPassword().equals(password)||cardActive.getBalance()<money){
            return Result.err(Result.CODE_ERR_BUSINESS,"密码错误或余额不足");
        }else{
            UserFinanceInfo userFinanceInfo=financeService.transactService(uid, cid, fid, money);
            if(userFinanceInfo!=null){
                return Result.ok("投资成功!",userFinanceInfo);
            }else{
                return Result.err(Result.CODE_ERR_BUSINESS,"出现问题，投资失败!");
            }
        }
    }
}
