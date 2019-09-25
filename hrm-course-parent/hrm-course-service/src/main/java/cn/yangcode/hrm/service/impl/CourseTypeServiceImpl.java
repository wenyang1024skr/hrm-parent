package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.client.RedisClient;
import cn.yangcode.hrm.domain.CourseType;
import cn.yangcode.hrm.mapper.CourseTypeMapper;
import cn.yangcode.hrm.service.ICourseTypeService;
import cn.yangcode.hrm.util.AjaxResult;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private RedisClient redisClient;
    //从redis中获取数据
    private List<CourseType> allCourseTypesRedis(){
        List<CourseType> courseTypeList = null;
        AjaxResult ajaxResult = redisClient.get("all_course_key");
        //redis里面有数据的时候
        if (ajaxResult.isSuccess() && ajaxResult.getResultObj() != null) {

            String ajaxResultResultObj = (String) ajaxResult.getResultObj();
            List<CourseType> typeList = JSON.parseArray(ajaxResultResultObj, CourseType.class);
            return typeList;
        }
        //redis里面没有数据的时候
        //从数据库拿数据然后再放入redis里
        courseTypeList = baseMapper.selectList(null);
        redisClient.set("all_course_key", JSON.toJSONString(courseTypeList));
        return courseTypeList;


    }

    @Override
    public List<CourseType> selectList(Wrapper<CourseType> wrapper) {
        //List<CourseType> courseTypeList = allCourseTypesRedis();
        return allCourseTypesRedis();
    }

    @Override
    public List<CourseType> treeData() {
        return baseMapper.selectParent();
    }

    @Override
    public CourseType selectParent(Long id) {
        return baseMapper.selectCurrent(id);
    }
}
