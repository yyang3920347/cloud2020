package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写负载均衡轮询算法接口
 *
 * @param null
 * @author yangyang
 * @date 2021/6/29 15:02
 * @return null
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}