package client;

import cn.yangcode.hrm.util.AjaxResult;
import fallback.PageClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * redis的调用的feign的接口
 */
@FeignClient(value = "hrm-pager-service",fallback = PageClientFallback.class )
public interface PageClient {

    @RequestMapping("/static/page")
    AjaxResult page(@RequestParam("pageName") String pageName, @RequestParam("dataKey") String dataKey);
}
