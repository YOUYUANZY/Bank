package com.cumtb.bank.service;

import com.cumtb.bank.entity.Finance;
import com.cumtb.bank.entity.FinanceType;

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
}
