package cpm.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyang
 * @date 2021/6/28-11:07
 **/
@Slf4j
@RestController
@RequestMapping("/consumerZK")
public class OrderZKController {
    /**
     * cloud-provider-payment 是zookeeper中注册的服务名称
     */
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
