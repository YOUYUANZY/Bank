package com.cumtb.bank.service;

import com.cumtb.bank.entity.Loan;

import java.util.List;

public interface LoanService {
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
}
