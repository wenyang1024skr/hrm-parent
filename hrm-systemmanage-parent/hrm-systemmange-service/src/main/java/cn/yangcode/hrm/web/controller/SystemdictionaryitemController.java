package cn.yangcode.hrm.web.controller;

import cn.yangcode.hrm.service.ISystemdictionaryitemService;
import cn.yangcode.hrm.domain.Systemdictionaryitem;
import cn.yangcode.hrm.query.SystemdictionaryitemQuery;
import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.util.PageList;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/systemdictionaryitem")
public class SystemdictionaryitemController {
    @Autowired
    public ISystemdictionaryitemService systemdictionaryitemService;

    /**
    * 保存和修改公用的
    * @param systemdictionaryitem  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Systemdictionaryitem systemdictionaryitem){
        try {
            if(systemdictionaryitem.getId()!=null){
                systemdictionaryitemService.updateById(systemdictionaryitem);
            }else{
                systemdictionaryitemService.insert(systemdictionaryitem);
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
            systemdictionaryitemService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Systemdictionaryitem get(@PathVariable("id")Long id)
    {
        return systemdictionaryitemService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Systemdictionaryitem> list(){
        return systemdictionaryitemService.selectList(null);
    }


    /**
     * 查看所有的课程等级信息
     * @return
     */
    @RequestMapping(value = "/courselevel/{sn}",method = RequestMethod.GET)
    public List<Systemdictionaryitem> courselevel(@PathVariable("sn")String sn){

        return systemdictionaryitemService.selectCourseLevelList(sn);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Systemdictionaryitem> json(@RequestBody SystemdictionaryitemQuery query)
    {
        //page里的是当前页和当前页的数据条数
        Page<Systemdictionaryitem> page = new Page<Systemdictionaryitem>(query.getPage(),query.getRows());
        EntityWrapper<Systemdictionaryitem> systemdictionaryitemEntityWrapper = new EntityWrapper<>();
        systemdictionaryitemEntityWrapper.like("name", query.getKeyword());
        page = systemdictionaryitemService.selectPage(page, systemdictionaryitemEntityWrapper);
        return new PageList<Systemdictionaryitem>(page.getTotal(),page.getRecords());
    }
}
