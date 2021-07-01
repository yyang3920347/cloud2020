package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写负载均衡轮询算法实现类
 *
 * @author yangyang
 * @date 2021/6/29-15:03
 **/
@Component //扫描组件
public class MyLB implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        //使用自旋锁
        do {
            current = this.atomicInteger.get();
            //不能超过整形的最大值2147483647
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问，次数：next=" + next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //注册中心的服务集合取余
        int index = getAndIncrement() % serviceInstances.size();
        //返回服务对象
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
