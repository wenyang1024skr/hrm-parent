package cn.yangcode.hrm.client;


import cn.yangcode.hrm.fallback.RedisClientFallback;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/24 19:51
 * @Description:
 */
@FeignClient(value = "hrm-redis-service",fallback = RedisClientFallback.class)
public interface RedisClient {
    @GetMapping("/redis/get/{key}")
    AjaxResult get(@PathVariable("key") String key);

    @PostMapping("/redis/set")
    AjaxResult set(@RequestParam("key") String key, @RequestParam("value") String value);

}
