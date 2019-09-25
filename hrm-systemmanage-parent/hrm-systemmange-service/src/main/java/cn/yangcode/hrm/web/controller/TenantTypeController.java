package cn.yangcode.hrm.web.controller;

import cn.yangcode.hrm.service.ITenantTypeService;
import cn.yangcode.hrm.domain.TenantType;
import cn.yangcode.hrm.query.TenantTypeQuery;
import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.util.PageList;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenantType")
public class TenantTypeController {
    @Autowired
    public ITenantTypeService tenantTypeService;

    /**
    * 保存和修改公用的
    * @param tenantType  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody TenantType tenantType){
        try {
            if(tenantType.getId()!=null){
                tenantTypeService.updateById(tenantType);
            }else{
                tenantTypeService.insert(tenantType);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            tenantTypeService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TenantType get(@PathVariable("id")Long id)
    {
        return tenantTypeService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<TenantType> list(){

        return tenantTypeService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<TenantType> json(@RequestBody TenantTypeQuery query)
    {
        Page<TenantType> page = new Page<TenantType>(query.getPage(),query.getRows());
        EntityWrapper<TenantType> tenantTypeEntityWrapper = new EntityWrapper<>();
        tenantTypeEntityWrapper.like("name", query.getKeyword());
        page = tenantTypeService.selectPage(page,tenantTypeEntityWrapper);
        return new PageList<TenantType>(page.getTotal(),page.getRecords());
    }
}
