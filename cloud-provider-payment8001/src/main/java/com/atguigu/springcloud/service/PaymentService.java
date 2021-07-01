package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangyang
 * @date 2021/4/25-19:53
 **/
public interface PaymentService {
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
