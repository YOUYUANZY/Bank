package com.cumtb.bank.repository;

import com.cumtb.bank.entity.LoanState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanStateRepository extends JpaRepository<LoanState,Integer> {
}
