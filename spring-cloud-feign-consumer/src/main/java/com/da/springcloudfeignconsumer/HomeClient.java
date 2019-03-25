package com.da.springcloudfeignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-provider")
public interface HomeClient {
    @GetMapping("/")
    String consumer();
}
