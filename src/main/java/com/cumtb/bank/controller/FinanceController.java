package com.cumtb.bank.controller;

import com.cumtb.bank.entity.Finance;
import com.cumtb.bank.entity.FinanceType;
import com.cumtb.bank.service.FinanceService;
import com.cumtb.bank.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {
    @Resource
    private FinanceService financeService;

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

    @RequestMapping("/getfinancetype")
    public Result getFinanceType(){
        List<FinanceType> financeTypeList=financeService.getFinanceTypeService();
        if(!financeTypeList.isEmpty()){
            return Result.ok("成功获取理财产品类型信息!",financeTypeList);
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS,"理财产品类型信息为空或查询错误!");
        }
    }
}
