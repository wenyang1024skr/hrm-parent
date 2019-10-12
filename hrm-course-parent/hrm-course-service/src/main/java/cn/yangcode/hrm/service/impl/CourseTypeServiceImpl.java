package cn.yangcode.hrm.service.impl;

import client.PageClient;
import cn.yangcode.hrm.client.RedisClient;
import cn.yangcode.hrm.client.SystemClient;
import cn.yangcode.hrm.constants.RedisConstants;
import cn.yangcode.hrm.domain.CourseType;
import cn.yangcode.hrm.mapper.CourseTypeMapper;
import cn.yangcode.hrm.service.ICourseTypeService;
import cn.yangcode.hrm.util.AjaxResult;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-23
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {
    @Autowired
    private PageClient pageClient;

    @Autowired
    private RedisClient redisClient;
    //从redis中获取数据
    private List<CourseType> allCourseTypesRedis(){
        List<CourseType> courseTypeList = null;
        courseTypeList = baseMapper.selectList(null);
        String toJSONString = JSON.toJSONString(courseTypeList);
        redisClient.set("all_course_key", toJSONString);


        AjaxResult ajaxResult = redisClient.get("all_course_key");
        //redis里面有数据的时候
        if (ajaxResult.isSuccess() && ajaxResult.getResultObj() != null) {

            String ajaxResultResultObj = (String) ajaxResult.getResultObj();
            List<CourseType> typeList = JSON.parseArray(ajaxResultResultObj, CourseType.class);
            return typeList;
        }
        //redis里面没有数据的时候
        //从数据库拿数据然后再放入redis里
        //courseTypeList = baseMapper.selectList(null);
        //String toJSONString = JSON.toJSONString(courseTypeList);
        //redisClient.set("all_course_key", toJSONString);
        return courseTypeList;


    }

    @Override
    public List<CourseType> selectList(Wrapper<CourseType> wrapper) {
        //List<CourseType> courseTypeList = allCourseTypesRedis();
        return allCourseTypesRedis();
    }

    @Override
    public List<CourseType> treeData() {
        //allCourseTypesRedis();
        return baseMapper.selectParent();
    }

    @Override
    public CourseType selectParent(Long id) {

        return baseMapper.selectCurrent(id);
    }
    private void doPageStaticForHome(){
        //1.准备页面静态化的 page的name
        String pageName = "home";

        //2.准备好填充的数据
        //模板路径：指的是，从fastdfs把模板的压缩包下载，解压到本地目录之后的那个本地目录路径
        //模板路径交个pager服务去确定

        //课程类型的层级结构的列表
        //这里需要把有层级结构的课程类型的数据存储到redis
        List<CourseType> courseTypes = treeData();
        Map<String,Object> map = new HashMap<>();
        map.put("courseTypes",courseTypes);

        redisClient.set(RedisConstants.KEY_TREEDATA_COURSETYPE, JSON.toJSONString(map));

        //3.调用pager服务做页面静态化
        pageClient.page(pageName, RedisConstants.KEY_TREEDATA_COURSETYPE);
    }

}
