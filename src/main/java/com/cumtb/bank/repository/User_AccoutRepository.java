package com.cumtb.bank.repository;


import com.cumtb.bank.entity.User_Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_AccoutRepository extends JpaRepository<User_Account,Integer>{
    User_Account findByCid(Integer cid);
}
