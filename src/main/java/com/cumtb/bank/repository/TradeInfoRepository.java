package com.cumtb.bank.repository;

import com.cumtb.bank.entity.FinanceType;
import com.cumtb.bank.entity.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeInfoRepository extends JpaRepository<TradeInfo,Integer> {
    TradeInfo findByTid(int tid);
}
