package com.da.springcloudfeignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider", fallbackFactory = HystrixClientFallbackFactory.class)   //指定新建的HystrixClientFallbackFactory 工厂类
public interface HomeClient {
    @GetMapping("/")
    String consumer();
}
