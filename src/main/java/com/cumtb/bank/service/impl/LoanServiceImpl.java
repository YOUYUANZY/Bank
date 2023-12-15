package com.cumtb.bank.service.impl;

import com.cumtb.bank.entity.Loan;
import com.cumtb.bank.repository.LoanRepository;
import com.cumtb.bank.service.LoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Resource
    private LoanRepository loanRepository;

    @Override
    public List<Loan> queryService(Integer uid, Integer cid, Integer type, Integer state) {
        if(cid!=0){
            List<Loan> loanList=loanRepository.findByUidAndCid(uid,cid);
            return loanList;
        }else if(type!=0){
            List<Loan> loanList=loanRepository.findByUidAndType(uid,type);
            return loanList;
        }else if(state!=0){
            List<Loan> loanList=loanRepository.findByUidAndState(uid, state);
            return loanList;
        }else{
            List<Loan> loanList=loanRepository.findByUid(uid);
            return loanList;
        }
    }
}
