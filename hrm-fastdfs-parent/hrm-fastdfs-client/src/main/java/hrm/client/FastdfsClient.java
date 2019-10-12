package hrm.client;

import cn.yangcode.hrm.util.AjaxResult;
import hrm.fallback.FastdfsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * redis的调用的feign的接口
 */
@FeignClient(value = "hrm-fastdfs-service",fallback = FastdfsClientFallback.class )
public interface FastdfsClient {

    @PostMapping("/fastdfs/download")
    byte[] download(@RequestParam("path") String path);

    @RequestMapping("/fastdfs/uploadBytes")
    AjaxResult uploadBytes(@RequestParam("bytes") byte[] bytes,
                           @RequestParam("extension") String extension);
}
