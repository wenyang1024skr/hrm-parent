package cn.yangcode.hrm.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/22 11:02
 * @Description:
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        //添加所有的微服务的文档资源
        /**
         * 参数:
         * name：自定义的服务的名字
         * location:指定是微服务的路径   /前缀/服务名/v2/api-docs
         */
        resources.add(swaggerResource("系统管理", "/hrm/system/v2/api-docs", "2.0"));

        return resources;
    }
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
