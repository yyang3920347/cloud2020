package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yangyang
 * @date 2021/4/25-19:33
 **/
@Mapper
@Repository
public interface PaymentDao {
    /**
     * 保存
     *
     * @param payment
     * @return
     */
    int save(Payment payment);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
