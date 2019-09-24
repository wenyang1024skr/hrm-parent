package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.domain.TenantType;
import cn.yangcode.hrm.mapper.TenantTypeMapper;
import cn.yangcode.hrm.service.ITenantTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户(机构)类型表 服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-24
 */
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
