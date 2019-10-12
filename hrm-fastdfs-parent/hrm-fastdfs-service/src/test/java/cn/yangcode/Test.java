package cn.yangcode;

import java.util.Arrays;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/28 14:57
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        String path = "/group1/M00/00/02/rBANDV2PbS6Abc8MAAKfHVLr4YA823.png";
        path = path.substring(1);
        System.out.println(path);
        String[] split = path.split("/",2);
        System.out.println(Arrays.toString(split));
        String groupName = split[0];
        System.out.println("=======groupName========="+groupName);
        String fileName = split[1];
        System.out.println("=======fileName========="+fileName);

    }
}
