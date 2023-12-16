package com.cumtb.bank.repository;

import com.cumtb.bank.entity.UserFinanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFinanceRepository extends JpaRepository<UserFinanceInfo,Integer> {

    List<UserFinanceInfo> findByUid(Integer uid);//根据用户标识查询投资信息

    List<UserFinanceInfo> findByUidAndCid(Integer uid,Integer cid);//根据用户标识和银行卡标识查询

    List<UserFinanceInfo> findByUidAndFid(Integer uid,Integer fid);//根据用户标识和理财产品标识查询
}
