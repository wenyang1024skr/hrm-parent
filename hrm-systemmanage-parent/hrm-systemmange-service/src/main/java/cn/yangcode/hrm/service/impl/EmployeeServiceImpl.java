package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.constants.MyException;
import cn.yangcode.hrm.domain.Employee;
import cn.yangcode.hrm.domain.Tenant;
import cn.yangcode.hrm.exception.GlobalException;
import cn.yangcode.hrm.mapper.EmployeeMapper;
import cn.yangcode.hrm.mapper.TenantMapper;
import cn.yangcode.hrm.service.IEmployeeService;
import cn.yangcode.hrm.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-09-26
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private TenantMapper tenantMapper;

    @Override
    public boolean insert(Employee entity) {
        //信息验证
        /*String companyName = entity.getTenant().getCompanyName();
        //判断是否为null并且length是否为0
        if (!StringUtils.hasLength(companyName)) {
            //自定义异常(不能为空)
            throw new GlobalException(MyException.ExceEXCEPTION_NULL.getErrorMsg());
        }

        Tenant selectCompanyName = baseMapper.selectCompanyName(companyName);
        //判断名字是否已经存在
        if (selectCompanyName != null) {
            throw new GlobalException(MyException.EXCEPTION_EXIST.getErrorMsg());
        }*/


        //先保存租户（tenant）信息，再保存employee
        Tenant entityTenant = entity.getTenant();
        tenantMapper.insert(entityTenant);
        //从tenant中获得id设置到employee的tenant_id中
        entity.setTenantId(entityTenant.getId());
        entity.setType(1L);
        //entity.setMealId(3L);
        Long mealId = entity.getMealID();
        super.insert(entity);

        //最后保存套餐，租户关系的中间表

        //在创建时间上加一年
        Date expireDate = DateUtils.addYears(new Date(), 1);
        baseMapper.insertTenantAndMeal(mealId, entityTenant.getId(), expireDate);

        return true;
    }
}
