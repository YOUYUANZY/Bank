package com.cumtb.bank.service;

import com.cumtb.bank.entity.Loan;
import com.cumtb.bank.entity.LoanState;
import com.cumtb.bank.entity.LoanType;

import java.util.List;

public interface LoanService {

    /**
     * 获取贷款状态信息
     * */
    List<LoanState> getLoanStateService();

    /**
     * 贷款查询业务
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param type 贷款类型
     * @param state 贷款状态
     * @return
     * ps:cid/type/state只能有一个不为0
     * */
    List<Loan> queryService(Integer uid,Integer cid,Integer type,Integer state);

    /**
     * 获取贷款类型信息
     * */
    List<LoanType> getLoanTypeService();

    /**
     * 办理贷款业务
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param amount 贷款金额
     * @param type 贷款类型
     * @return
     * */
    Loan transactService(Integer uid,Integer cid,Float amount,Integer type);
}
