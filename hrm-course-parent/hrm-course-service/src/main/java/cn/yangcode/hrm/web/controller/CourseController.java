package cn.yangcode.hrm.web.controller;

import cn.yangcode.hrm.Dto.CourseDto;
import cn.yangcode.hrm.service.ICourseService;
import cn.yangcode.hrm.domain.Course;
import cn.yangcode.hrm.query.CourseQuery;
import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.util.PageList;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public ICourseService courseService;

    /**
    * 保存和修改公用的
    * @param course  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Course course){
        try {
            if(course.getId()!=null){
                courseService.updateById(course);
            }else{
                courseService.insert(course);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }
    /**
     * 保存和修改公用的
     * @param courseDto  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/saveAboutCourse",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseDto courseDto){
        try {
            if(courseDto.getCourse().getId()!=null){

            }else{
                courseService.insert(courseDto);
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
            courseService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Course get(@PathVariable("id")Long id)
    {
        return courseService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Course> list(){

        return courseService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<Course> json(@RequestBody CourseQuery query)
    {
        Page<Course> page = new Page<Course>(query.getPage(),query.getRows());
        EntityWrapper<Course> courseEntityWrapper = new EntityWrapper<>();
        courseEntityWrapper.like("name", query.getKeyword());
        page = courseService.selectPage(page,courseEntityWrapper);
        return new PageList<Course>(page.getTotal(),page.getRecords());
    }
}
