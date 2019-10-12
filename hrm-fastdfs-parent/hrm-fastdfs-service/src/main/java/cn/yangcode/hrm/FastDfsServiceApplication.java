package cn.yangcode.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/27 17:41
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FastDfsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastDfsServiceApplication.class);
    }
}
