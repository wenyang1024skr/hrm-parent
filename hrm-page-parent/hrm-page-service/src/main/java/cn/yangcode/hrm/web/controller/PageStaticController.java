package cn.yangcode.hrm.web.controller;

import cn.yangcode.hrm.service.IPagerService;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Wenyang
 * @Date: 2019/10/11 21:16
 * @Description:
 */
@RestController
@RequestMapping("/pagestatic")
public class PageStaticController {
    @Autowired
    private IPagerService pagerService;

    @RequestMapping("/page")
    public AjaxResult page(@RequestParam("pageName") String pageName , @RequestParam("dataKey")String dataKey){
        pagerService.staticPage(pageName , dataKey);
        return AjaxResult.me();
    }
}
