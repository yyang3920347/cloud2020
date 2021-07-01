package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangyang
 * @date 2021/6/29-16:50
 * 配置日志bean
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        //FULL 详细日志
        return Logger.Level.FULL;
    }
}
