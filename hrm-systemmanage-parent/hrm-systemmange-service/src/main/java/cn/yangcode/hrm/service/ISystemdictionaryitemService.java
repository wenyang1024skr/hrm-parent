package cn.yangcode.hrm.service;

import cn.yangcode.hrm.domain.Systemdictionaryitem;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-22
 */
public interface ISystemdictionaryitemService extends IService<Systemdictionaryitem> {

    List<Systemdictionaryitem> selectCourseLevelList(String sn);
}
