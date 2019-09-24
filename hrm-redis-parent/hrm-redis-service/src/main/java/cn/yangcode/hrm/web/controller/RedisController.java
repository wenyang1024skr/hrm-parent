package cn.yangcode.hrm.web.controller;


import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.utils.RedisUtils;
import org.springframework.web.bind.annotation.*;

/**
 * redis的接口
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @GetMapping("/get/{key}")
    public AjaxResult get(@PathVariable("key")String key){
        String result = RedisUtils.INSTANCE.get(key);
        return AjaxResult.me().setResultObj(result);
    }
    @PostMapping("/set")
    public AjaxResult set(@RequestParam("key")String key,@RequestParam("value")String value){
        RedisUtils.INSTANCE.set(key,value);
        return AjaxResult.me();
    }
}