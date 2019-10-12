package fallback;

import client.PageClient;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.stereotype.Service;

@Service
public class PageClientFallback implements PageClient {
    @Override
    public AjaxResult page(String pageName, String dataKey) {
        return AjaxResult.me().setSuccess(false).setMessage("页面静态化不可用");
    }
}
