package com.da.springcloudribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultStores") //该注解对该方法创建了熔断器的功能,并指定了defaultStores熔断方法，熔断方法直接返回了一个字符串， "feign + hystrix ,提供者服务挂了" @HystrixCommand 表明该方法为hystrix包裹，可以对依赖服务进行隔离、降级、快速失败、快速重试等等hystrix相关功能该注解属性较多，下面讲解其中几个
    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }

    //可以访问 http://127.0.0.1:9090/hystrix ,获取Hystrix Dashboard信息，默认最大打开5个终端获取监控信息，可以增加delay参数指定获取监控数据间隔时间

    //在界面依次输入：http://127.0.0.1:9000/hystrix.stream 、2000 、hello 点确定。可以访问以下，图形化监控页面

    public String defaultStores() {
        return "Ribbon + hystrix Dashboard ,提供者服务挂了";
    }
}
