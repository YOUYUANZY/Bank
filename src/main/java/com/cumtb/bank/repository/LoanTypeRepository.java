package com.cumtb.bank.repository;

import com.cumtb.bank.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanType,Integer> {
    LoanType findByType(Integer type);//根据贷款类型代码查询贷款类型信息
}
