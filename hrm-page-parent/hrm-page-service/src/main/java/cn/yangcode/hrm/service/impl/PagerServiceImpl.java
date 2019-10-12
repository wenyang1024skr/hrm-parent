package cn.yangcode.hrm.service.impl;

import cn.yangcode.hrm.client.RedisClient;
import cn.yangcode.hrm.domain.PageConfig;
import cn.yangcode.hrm.domain.Pager;
import cn.yangcode.hrm.exception.GlobalException;
import cn.yangcode.hrm.mapper.PageConfigMapper;
import cn.yangcode.hrm.mapper.PagerMapper;
import cn.yangcode.hrm.service.IPagerService;
import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.util.ZipUtils;
import cn.yangcode.hrm.utils.VelocityUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import hrm.client.FastdfsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenyang
 * @since 2019-10-11
 */
@Service
public class PagerServiceImpl extends ServiceImpl<PagerMapper, Pager> implements IPagerService {

    @Autowired
    private FastdfsClient fastdfsClient;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private PageConfigMapper pageConfigMapper;


    @Override
    public void staticPage(String pageName, String dataKey) {
        //由pageName查询pager对象
        Pager pager = baseMapper.selectByName(pageName);
        //从pager中拿到模板路径
        String tempFastdfsUrl = pager.getTemplateUrl();
        //下载zip
        byte[] vmByte = fastdfsClient.download(tempFastdfsUrl);
        if (vmByte == null || vmByte.length == 0) {
            throw new GlobalException("下载失败");
        }
        //解压模板到临时目录
        String basePath = System.getProperty("java.io.tmpdir") + "static/";
        String vmZipPath = basePath + pageName + ".zip";
        File zipFile = new File(vmZipPath);
        //判断文件是否存在
        try {
            if (!zipFile.exists()) {
                zipFile.getParentFile().mkdirs();
                zipFile.createNewFile();
            }
            //把文件拷贝到本地
            FileCopyUtils.copy(vmByte, zipFile);
            //解压
            ZipUtils.unZip(vmZipPath,basePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //拿到解压目录的路径作为填充数据
        //根据dataKey从redis中获取到填充的数据
        AjaxResult dataAjax = redisClient.get(dataKey);
        if (!dataAjax.isSuccess() || dataAjax.getResultObj() == null) {
            throw new GlobalException("填充数据获取失败");
        }

        //转换填充数据
        Map<String,Object> map = JSON.parseObject(dataAjax.getResultObj().toString(), Map.class);
        map.put("staticRoot", basePath);

        //用模板引擎合并模板生成html
        String templatePath = basePath+pageName+".vm";
        String htmlOutPath = basePath+pageName+".html";

        VelocityUtils.staticByTemplate(map, templatePath, htmlOutPath);
        //上传fastdfs
        byte[] bytes = new byte[0];
        try {
            bytes = FileCopyUtils.copyToByteArray(new File(htmlOutPath));
            AjaxResult htmlAjax = fastdfsClient.uploadBytes(bytes, "html");
            if (!htmlAjax.isSuccess()) {
                throw new GlobalException("上传失败");
            }
            //保存page-config记录到数据库
            PageConfig pageConfig = new PageConfig();
            //将key保存到redis
            pageConfig.setDataKey(dataKey);
            //文件服务器的类型 1：fastdfs
            pageConfig.setDfsType(1L);
            //pager表的id
            pageConfig.setPageId(pager.getId());
            //html在fast的路径
            pageConfig.setPageUrl(htmlAjax.getResultObj().toString());
            //html需要拷贝到nginx的那个磁盘路径
            pageConfig.setPhysicalPath(pager.getPhysicalPath());
            pageConfig.setTemplateUrl(pager.getTemplateUrl());
            pageConfigMapper.insert(pageConfig);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
