package cn.yangcode.hrm.client;

import cn.yangcode.hrm.doc.CourseDoc;
import cn.yangcode.hrm.fallback.EsClientFallback;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * redis的调用的feign的接口
 */
@FeignClient(value = "hrm-es-service",fallback = EsClientFallback.class )
public interface EsClient {

    @PostMapping("/es/save")
    AjaxResult save(@RequestBody CourseDoc courseDoc);

    @PostMapping("/es/delete/{id}")
    AjaxResult delete(@PathVariable("id") Long id);
}
