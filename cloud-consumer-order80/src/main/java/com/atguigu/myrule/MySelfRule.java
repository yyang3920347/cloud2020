package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangyang
 * @date 2021/6/29-14:37
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //RandomRule 负载规则：随机
        return new RandomRule();
    }
}
