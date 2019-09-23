package cn.yangcode.hrm.mapper;

import cn.yangcode.hrm.domain.CourseType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 课程目录 Mapper 接口
 * </p>
 *
 * @author wenyang
 * @since 2019-09-23
 */
public interface CourseTypeMapper extends BaseMapper<CourseType> {

    List<CourseType> selectParent();

    CourseType selectCurrent(Long id);
}
