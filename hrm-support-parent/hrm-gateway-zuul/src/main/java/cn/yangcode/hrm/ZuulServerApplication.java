package cn.yangcode.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/21 13:07
 * @Description:网关配置（@EnableDiscoveryClient开启注册中心客户端，@EnableZuulProxy开启zuul）
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class);
    }
}
