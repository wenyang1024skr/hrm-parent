package cn.yangcode.hrm.service;

import cn.yangcode.hrm.Dto.CourseDto;
import cn.yangcode.hrm.domain.Course;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-29
 */
public interface ICourseService extends IService<Course> {
    void insert(CourseDto courseDto);

}
