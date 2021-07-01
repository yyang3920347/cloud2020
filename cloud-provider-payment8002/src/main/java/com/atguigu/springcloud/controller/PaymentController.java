package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangyang
 * @date 2021/4/25-19:56
 **/
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        CommonResult<Payment> commonResult = new CommonResult<>();
        int save = paymentService.save(payment);
        if (save == 1) {
            commonResult.setCode(200);
            commonResult.setMessage("插入成功,serverPort=" + serverPort);
        } else {
            commonResult.setCode(444);
            commonResult.setMessage("插入失败,serverPort=" + serverPort);
        }
        return commonResult;
    }

    /**
     * 根据id查询
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = new CommonResult<>();
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果={}", payment);
        if (null == payment) {
            commonResult.setData(null);
            commonResult.setMessage("没有对应记录，查询id=" + id + ",serverPort=" + serverPort);
        } else {
            commonResult.setData(payment);
            commonResult.setMessage("查询成功,serverPort=" + serverPort);
        }
        return commonResult;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
