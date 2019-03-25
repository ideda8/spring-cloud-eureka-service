package com.da.springcloudeurekaprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope   //开启 SpringCloudConfig 客户端的 refresh 刷新范围，来获取服务端的最新配置，@RefreshScope要加在声明@Controller声明的类上，否则refresh之后Conroller拿不到最新的值，会默认调用缓存。
@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudEurekaProviderApplication {

    @Value("${content}")
    String content;

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String home() {
        return "Hello world ,port:" + port+",content="+content;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaProviderApplication.class, args);
    }

}
