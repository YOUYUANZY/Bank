package com.cumtb.bank.service.impl;

import com.cumtb.bank.entity.Finance;
import com.cumtb.bank.entity.FinanceType;
import com.cumtb.bank.entity.UserFinanceInfo;
import com.cumtb.bank.repository.FinanceRepository;
import com.cumtb.bank.repository.FinanceTypeRepository;
import com.cumtb.bank.repository.UserFinanceRepository;
import com.cumtb.bank.service.FinanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Resource
    private FinanceRepository financeRepository;
    @Resource
    private FinanceTypeRepository financeTypeRepository;
    @Resource
    private UserFinanceRepository userFinanceRepository;

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

    @Override
    public List<UserFinanceInfo> queryService(Integer uid, Integer cid, Integer fid) {
        if(cid!=0){
            List<UserFinanceInfo> userFinanceInfoList=userFinanceRepository.findByUidAndCid(uid, cid);
            return userFinanceInfoList;
        }else if(fid!=0){
            List<UserFinanceInfo> userFinanceInfoList=userFinanceRepository.findByUidAndFid(uid, fid);
            return userFinanceInfoList;
        }else{
            List<UserFinanceInfo> userFinanceInfoList=userFinanceRepository.findByUid(uid);
            return userFinanceInfoList;
        }
    }

    @Override
    public UserFinanceInfo transactService(Integer uid, Integer cid, Integer fid, Float money) {
        UserFinanceInfo userFinanceInfo=new UserFinanceInfo();
        userFinanceInfo.setUid(uid);
        userFinanceInfo.setCid(cid);
        userFinanceInfo.setFid(fid);
        userFinanceInfo.setMoney(money);
        userFinanceInfo.setStarttime(new Timestamp(new Date().getTime()));
        UserFinanceInfo newUserFinanceInfo=userFinanceRepository.save(userFinanceInfo);
        return newUserFinanceInfo;
    }
}
