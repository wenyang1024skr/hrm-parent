package cn.yangcode.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/21 13:11
 * @Description:
 */
@SpringBootApplication
//开启配置中心客户端
@EnableDiscoveryClient
public class SystemManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemManageApplication.class);
    }
}
