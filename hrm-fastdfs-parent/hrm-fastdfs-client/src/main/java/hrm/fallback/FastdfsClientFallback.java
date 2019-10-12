package hrm.fallback;

import cn.yangcode.hrm.util.AjaxResult;
import hrm.client.FastdfsClient;
import org.springframework.stereotype.Service;

@Service
public class FastdfsClientFallback implements FastdfsClient {
    @Override
    public byte[] download(String path) {
        return null;
    }

    @Override
    public AjaxResult uploadBytes(byte[] bytes, String extension) {
        return AjaxResult.me().setSuccess(false).setMessage("fastdfs不可用");
    }
}
