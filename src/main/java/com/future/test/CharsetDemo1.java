package com.future.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author guorui
 * @create 2022-06-01-20:14
 */
public class CharsetDemo1 {
    public static void main(String[] args) throws Exception {
        String name = "abc我爱你中国";
        //将字符串按GBK编码  前后必须一致，可以用GBK,UTF-8,ISO8859-1
        byte[] bytes = name.getBytes("ISO8859-1");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        //将字符串按GBK解码  前后必须一致，可以用GBK,UTF-8,ISO8859-1
        String rs = new String(bytes,"UTF-8");
        System.out.println(rs);
    }
}
