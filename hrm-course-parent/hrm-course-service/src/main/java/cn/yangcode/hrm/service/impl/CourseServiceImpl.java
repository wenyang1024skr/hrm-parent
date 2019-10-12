package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.Dto.CourseDto;
import cn.yangcode.hrm.client.SystemClient;
import cn.yangcode.hrm.domain.Course;
import cn.yangcode.hrm.domain.CourseDetail;
import cn.yangcode.hrm.domain.CourseMarket;
import cn.yangcode.hrm.domain.Systemdictionaryitem;
import cn.yangcode.hrm.mapper.CourseDetailMapper;
import cn.yangcode.hrm.mapper.CourseMapper;
import cn.yangcode.hrm.mapper.CourseMarketMapper;
import cn.yangcode.hrm.service.ICourseDetailService;
import cn.yangcode.hrm.service.ICourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-29
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private CourseDetailMapper courseDetailMapper;

    @Autowired
    private CourseMarketMapper courseMarketMapper;

    @Autowired
    private SystemClient systemClient;


    //保存前台封装好的三个对象（分别在三张表中）
    @Override
    public void insert(CourseDto courseDto) {
        //先保存课程表中的信息，在保存课程明细里的信息，最后保存营销表中的信息
        //课程
        Course course = courseDto.getCourse();
        course.setTenantId(2L);
        course.setName("xx科技公司");
        course.setUserId(3L);
        course.setUserName("hahha");
        course.setTenantName("rhgoeh");
        Systemdictionaryitem systemdictionaryitem = systemClient.get(course.getGrade());
        course.setGradeName(systemdictionaryitem.getName());
        baseMapper.insert(course);

        //课程明细
        CourseDetail courseDetail = courseDto.getCourseDetail();
        courseDetailMapper.insert(courseDetail);
        //营销表
        CourseMarket courseMarket = courseDto.getCourseMarket();
        courseMarketMapper.insert(courseMarket);


    }
}
