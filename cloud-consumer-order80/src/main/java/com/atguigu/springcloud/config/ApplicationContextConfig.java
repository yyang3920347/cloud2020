package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyang
 * @date 2021/6/28-11:07
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //赋予负载均衡，可以使用eureka里的服务名称（CLOUD-PAYMENT-SERVICE）进行请求
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
