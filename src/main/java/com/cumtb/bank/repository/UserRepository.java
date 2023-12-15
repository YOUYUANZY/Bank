package com.cumtb.bank.repository;

import com.cumtb.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 自定义查询
     * @Query(value = "select * from user where uname LIKE ?1 OR email LIKE ?2 OR lastdid LIKE ?3 OR uid LIKE ?4",nativeQuery = true)
     * Page<User> findUserswithoutgender(
     *         String uname,
     *         String email,
     *         String lastdid,
     *         String uid,
     *         Pageable request
     * );
     * */
    /**
     * 可以自动查询，驼峰命名法
     * */
    User findByUid(Integer uid);//通过uid查找用户

    User findById(String id);//通过身份证号查找用户

    User findByPhone(String phone);//通过手机号查找用户

    User findByPhoneAndPassword(String phone,String password);//通过手机号和密码查找用户

    User findByNameAndPhoneAndId(String name,String phone,String id);//通过姓名、手机号、身份证号查找用户
}
