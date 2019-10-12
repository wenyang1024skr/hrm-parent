package cn.yangcode.hrm.mapper;

import cn.yangcode.hrm.domain.Pager;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenyang
 * @since 2019-10-11
 */
public interface PagerMapper extends BaseMapper<Pager> {

    Pager selectByName(@Param("pageName")String pageName);
}
