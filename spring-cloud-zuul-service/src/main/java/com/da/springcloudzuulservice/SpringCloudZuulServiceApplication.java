package com.da.springcloudzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulServiceApplication.class, args);
    }

}
