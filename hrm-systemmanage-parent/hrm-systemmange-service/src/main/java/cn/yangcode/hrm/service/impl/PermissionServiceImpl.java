package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.domain.Permission;
import cn.yangcode.hrm.mapper.PermissionMapper;
import cn.yangcode.hrm.service.IPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
