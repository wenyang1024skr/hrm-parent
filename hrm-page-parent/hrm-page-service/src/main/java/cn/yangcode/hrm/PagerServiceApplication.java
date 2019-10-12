package cn.yangcode.hrm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: Wenyang
 * @Date: 2019/10/11 20:53
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.yangcode.hrm.client")
public class PagerServiceApplication {
}
