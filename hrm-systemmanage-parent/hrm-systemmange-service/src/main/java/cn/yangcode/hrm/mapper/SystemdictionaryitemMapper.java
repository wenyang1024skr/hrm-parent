package cn.yangcode.hrm.mapper;

import cn.yangcode.hrm.domain.Systemdictionaryitem;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenyang
 * @since 2019-09-22
 */
public interface SystemdictionaryitemMapper extends BaseMapper<Systemdictionaryitem> {

    List<Systemdictionaryitem> CourseLevelList(String sn);
}
