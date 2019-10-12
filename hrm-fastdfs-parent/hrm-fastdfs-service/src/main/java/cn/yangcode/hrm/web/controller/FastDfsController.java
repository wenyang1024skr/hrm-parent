package cn.yangcode.hrm.web.controller;

import cn.yangcode.hrm.util.AjaxResult;
import cn.yangcode.hrm.utils.FastDfsApiOpr;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/28 09:11
 * @Description:
 */
@RestController
@RequestMapping("/fast")
public class FastDfsController {
    //上传
    @RequestMapping(value = "/upload")
    public AjaxResult upload(MultipartFile file) throws Exception {

        System.out.println("-------file--------" + file);
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String upload = FastDfsApiOpr.upload(file.getBytes(), extension);
        System.out.println("=====upload======" + upload);
        return AjaxResult.me().setResultObj(upload);
    }
    //上传相册
    @RequestMapping(value = "/uploadpic")
    public AjaxResult uploadPic(MultipartFile file) throws Exception {

        System.out.println("-------file--------" + file);
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String upload = FastDfsApiOpr.upload(file.getBytes(), extension);
        System.out.println("=====upload======" + upload);
        return AjaxResult.me().setResultObj(upload);
    }
    //删除
    @RequestMapping(value = "/delete")
    public AjaxResult del(@RequestBody Map<String,String> para) {
        //System.out.println("-------------para--------------"+para);
        //System.out.println(para.get("path"));
        String path = para.get("path");
        path = path.substring(1);
        String[] split = path.split("/",2);
        String groupName = split[0];
        //System.out.println("=======groupName========="+groupName);
        String fileName = split[1];
        //System.out.println("=======fileName========="+fileName);
        boolean delete = FastDfsApiOpr.delete(groupName, fileName);


        return AjaxResult.me().setSuccess(delete);
    }
    @RequestMapping(value = "/downLoad")
    public AjaxResult downLoad(@RequestBody Map<String,String> para) throws Exception {
        //System.out.println("-------------para--------------"+para);
        //System.out.println(para.get("path"));
        String path = para.get("path");
        String[] split = path.split("/",5);
        //System.out.println(Arrays.toString(split));
        String groupName = split[3];
        System.out.println("=======groupName========="+groupName);
        String fileName = split[4];
        System.out.println("=======fileName========="+fileName);
        byte[] download = FastDfsApiOpr.download(groupName, fileName);
        //流保存图片......
        String[] strings = path.split("/");
        String suffix = strings[strings.length - 1];
        String url = "D://testDownImg/" + suffix;
        System.out.println(url);

        OutputStream outputStream = new FileOutputStream(url);
        outputStream.write(download,0,download.length);
        outputStream.flush();
        outputStream.close();


        return AjaxResult.me().setSuccess(true);
    }


}
