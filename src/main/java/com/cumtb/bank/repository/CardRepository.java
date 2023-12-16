package com.cumtb.bank.repository;

import com.cumtb.bank.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
    Card findByCid(Integer cid);
}
