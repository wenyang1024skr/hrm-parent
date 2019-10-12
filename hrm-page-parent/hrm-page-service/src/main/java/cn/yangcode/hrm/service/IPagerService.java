package cn.yangcode.hrm.service;

import cn.yangcode.hrm.domain.Pager;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenyang
 * @since 2019-10-11
 */
public interface IPagerService extends IService<Pager> {

    void staticPage(String pageName, String dataKey);
}
