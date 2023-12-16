package com.cumtb.bank.repository;

import com.cumtb.bank.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByUid(Integer uid);//查询用户的所有贷款

    List<Loan> findByUidAndCid(Integer uid,Integer cid);//查询用户某张卡的贷款

    List<Loan> findByUidAndType(Integer uid,Integer type);//查询用户某一类贷款

    List<Loan> findByUidAndState(Integer uid,Integer state);//查询用户某种情况的贷款

}
