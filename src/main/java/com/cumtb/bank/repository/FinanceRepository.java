package com.cumtb.bank.repository;

import com.cumtb.bank.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance,Integer> {
    List<Finance> findByType(Integer type);//根据理财产品类型查询信息
}
