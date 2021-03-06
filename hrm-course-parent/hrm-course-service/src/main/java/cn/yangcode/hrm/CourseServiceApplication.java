package cn.yangcode.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/23 12:52
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.yangcode.hrm.client")
public class CourseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class);
    }

}
