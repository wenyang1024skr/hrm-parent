package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.domain.Systemdictionaryitem;
import cn.yangcode.hrm.mapper.SystemdictionaryitemMapper;
import cn.yangcode.hrm.service.ISystemdictionaryitemService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-22
 */
@Service
public class SystemdictionaryitemServiceImpl extends ServiceImpl<SystemdictionaryitemMapper, Systemdictionaryitem> implements ISystemdictionaryitemService {

    @Override
    public List<Systemdictionaryitem> selectCourseLevelList(String sn) {
        return baseMapper.CourseLevelList(sn);
    }
}
