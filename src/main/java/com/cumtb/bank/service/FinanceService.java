package com.cumtb.bank.service;

import com.cumtb.bank.entity.Finance;
import com.cumtb.bank.entity.FinanceType;
import com.cumtb.bank.entity.UserFinanceInfo;

import java.util.List;

public interface FinanceService {
    /**
     * 获取理财产品信息
     * @param type 理财产品类型
     * @return
     * ps:type为0表示获取所有类型的理财产品信息
     * */
    List<Finance> getFinanceOfService(Integer type);

    /**
     * 获取理财产品类型信息
     * @param
     * @return
     * */
    List<FinanceType> getFinanceTypeService();

    /**
     * 查询理财账单业务
     * @param uid 用户标识
     * @param cid
     * @param fid
     * @return
     * */
    List<UserFinanceInfo> queryService(Integer uid,Integer cid,Integer fid);

    /**
     * 投资理财业务
     * @param uid 用户标识
     * @param cid 银行卡标识
     * @param fid 理财产品标识
     * @param money 投资金额
     * @return
     * */
    UserFinanceInfo transactService(Integer uid,Integer cid,Integer fid,Float money);
}
