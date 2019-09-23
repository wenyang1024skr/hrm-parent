package cn.yangcode.hrm.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/22 09:46
 * @Description: 分页插件
 */
//事务管理
@EnableTransactionManagement
@Configuration
//mapper接口扫描
@MapperScan("cn.yangcode.hrm.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
