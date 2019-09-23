package cn.yangcode.hrm.service;

import cn.yangcode.hrm.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-23
 */
public interface ICourseTypeService extends IService<CourseType> {

    List<CourseType> treeData();

    CourseType selectParent(Long id);
}
