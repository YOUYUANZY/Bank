package com.cumtb.bank.service.impl;

import com.cumtb.bank.entity.Finance;
import com.cumtb.bank.entity.FinanceType;
import com.cumtb.bank.repository.FinanceRepository;
import com.cumtb.bank.repository.FinanceTypeRepository;
import com.cumtb.bank.service.FinanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Resource
    private FinanceRepository financeRepository;
    @Resource
    private FinanceTypeRepository financeTypeRepository;

    @Override
    public List<Finance> getFinanceOfService(Integer type) {
        List<Finance> financeList;
        if(type!=0){
            financeList = financeRepository.findByType(type);
        }else{
            financeList = financeRepository.findAll();
        }
        return financeList;
    }

    @Override
    public List<FinanceType> getFinanceTypeService() {
        List<FinanceType> financeTypeList=financeTypeRepository.findAll();
        return financeTypeList;
    }
}
