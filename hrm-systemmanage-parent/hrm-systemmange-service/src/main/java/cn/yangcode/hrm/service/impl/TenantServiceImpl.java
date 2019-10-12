package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.domain.Tenant;
import cn.yangcode.hrm.mapper.TenantMapper;
import cn.yangcode.hrm.service.ITenantService;
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
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
