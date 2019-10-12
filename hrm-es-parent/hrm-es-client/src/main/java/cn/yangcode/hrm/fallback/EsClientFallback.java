package cn.yangcode.hrm.fallback;


import cn.yangcode.hrm.client.EsClient;
import cn.yangcode.hrm.doc.CourseDoc;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.stereotype.Service;

@Service
public class EsClientFallback implements EsClient {
    @Override
    public AjaxResult save(CourseDoc courseDoc) {
        return AjaxResult.me().setSuccess(false).setMessage("ES服务不可用");
    }

    @Override
    public AjaxResult delete(Long id) {
        return AjaxResult.me().setSuccess(false).setMessage("ES服务不可用");
    }
}
