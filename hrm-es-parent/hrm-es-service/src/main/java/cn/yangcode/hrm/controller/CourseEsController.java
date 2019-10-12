package cn.yangcode.hrm.controller;


import cn.yangcode.hrm.doc.CourseDoc;
import cn.yangcode.hrm.repository.CourseElasticsearchRepository;
import cn.yangcode.hrm.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/es")
public class CourseEsController {

    @Autowired
    private CourseElasticsearchRepository courseElasticsearchRepository;

    //保存
    @PostMapping("/save")
    public AjaxResult save(@RequestBody CourseDoc courseDoc){
        courseElasticsearchRepository.save(courseDoc);
        return AjaxResult.me();
    }
    //移除
    @PostMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable("id")Long id){
        courseElasticsearchRepository.deleteById(id);
        return AjaxResult.me();
    }
}
