package com.cumtb.bank.service.impl;

import com.cumtb.bank.entity.Loan;
import com.cumtb.bank.entity.LoanState;
import com.cumtb.bank.entity.LoanType;
import com.cumtb.bank.repository.LoanRepository;
import com.cumtb.bank.repository.LoanStateRepository;
import com.cumtb.bank.repository.LoanTypeRepository;
import com.cumtb.bank.service.LoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Resource
    private LoanRepository loanRepository;
    @Resource
    private LoanTypeRepository loanTypeRepository;
    @Resource
    private LoanStateRepository loanStateRepository;

    @Override
    public List<LoanState> getLoanStateService() {
        List<LoanState> loanStateList=loanStateRepository.findAll();
        return loanStateList;
    }

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

    @Override
    public List<LoanType> getLoanTypeService() {
        List<LoanType> loanTypeList=loanTypeRepository.findAll();
        return loanTypeList;
    }

    @Override
    public Loan transactService(Integer uid, Integer cid, Float amount, Integer type) {
        Loan loan=new Loan();
        loan.setUid(uid);
        loan.setCid(cid);
        loan.setAmount(amount);
        loan.setStarttime(new Timestamp(new Date().getTime()));
        loan.setType(type);
        loan.setState(1);
        LoanType loanType=loanTypeRepository.findByType(type);
        loan.setRest(amount*(1.0f+loanType.getRate()));
        Loan newLoan=loanRepository.save(loan);
        return newLoan;
    }
}
