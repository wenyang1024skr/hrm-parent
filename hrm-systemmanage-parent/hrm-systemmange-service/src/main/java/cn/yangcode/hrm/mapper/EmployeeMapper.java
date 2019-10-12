package cn.yangcode.hrm.mapper;

import cn.yangcode.hrm.domain.Employee;
import cn.yangcode.hrm.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenyang
 * @since 2019-09-26
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    void insertTenantAndMeal(@Param("mealId") Long mealId,@Param("tenantId") Long tenantId,@Param("expireDate") Date expireDate);

    Tenant selectCompanyName(String companyName);
}
