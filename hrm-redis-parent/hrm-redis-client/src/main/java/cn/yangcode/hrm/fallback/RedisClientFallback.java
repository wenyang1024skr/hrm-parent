package cn.yangcode.hrm.fallback;

import cn.yangcode.hrm.client.RedisClient;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.stereotype.Component;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/24 19:55
 * @Description:
 */
@Component
public class RedisClientFallback implements RedisClient {
    @Override
    public AjaxResult get(String key) {
        return AjaxResult.me().setSuccess(false).setMessage("getError!!!");
    }

    @Override
    public AjaxResult set(String key, String value) {
        return AjaxResult.me().setSuccess(false).setMessage("setError!!!");
    }
}
