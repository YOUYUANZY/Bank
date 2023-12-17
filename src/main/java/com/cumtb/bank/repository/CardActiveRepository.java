package com.cumtb.bank.repository;

import com.cumtb.bank.entity.CardActive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardActiveRepository extends JpaRepository<CardActive,Integer> {
    CardActive findByCid(Integer cid);//根据cid查询余额

}
