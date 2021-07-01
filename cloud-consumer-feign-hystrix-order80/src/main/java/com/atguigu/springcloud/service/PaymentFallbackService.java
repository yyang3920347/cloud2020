package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yangyang
 * @date 2021/6/30-15:29
 **/
@Component //组件注解，否则扫描不到
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK, /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut, /(ㄒoㄒ)/~~";
    }
}
