package cn.yangcode.hrm.client;


import cn.yangcode.hrm.domain.Systemdictionaryitem;
import cn.yangcode.hrm.fallback.SystemClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/24 19:51
 * @Description:
 */
@FeignClient(value = "hrm-systemmanage-service",fallback =SystemClientFallback.class)
public interface SystemClient {
    @RequestMapping(value = "/systemdictionaryitem/{id}",method = RequestMethod.GET)
    Systemdictionaryitem get(@PathVariable("id")Long id);
}
