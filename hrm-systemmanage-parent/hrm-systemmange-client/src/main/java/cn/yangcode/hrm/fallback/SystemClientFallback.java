package cn.yangcode.hrm.fallback;

import cn.yangcode.hrm.client.SystemClient;
import cn.yangcode.hrm.domain.Systemdictionaryitem;
import org.springframework.stereotype.Component;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/24 19:55
 * @Description:
 */
@Component
public class SystemClientFallback implements SystemClient {

    @Override
    public Systemdictionaryitem get(Long id) {
        return null;
    }
}
