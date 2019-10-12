package cn.yangcode;

import java.util.Arrays;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/28 15:53
 * @Description:
 */
public class TestDownLoad {
    public static void main(String[] args) {
        String path = "http://172.16.13.13/group1/M00/00/02/rBANDV2PZQWAbsc4AAKfHVLr4YA154.png";
        //path = path.substring(1);
        System.out.println(path);
        String[] split = path.split("/",5);
        System.out.println(Arrays.toString(split));
        String groupName = split[3];
        System.out.println("=======groupName========="+groupName);
        String fileName = split[4];
        System.out.println("=======fileName========="+fileName);

        String[] strings = path.split("/");
        String suffix = strings[strings.length - 1];
        System.out.println("========suffix========"+suffix);
        System.out.println(suffix);

    }
}
