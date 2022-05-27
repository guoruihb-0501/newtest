package com.future.test;

import java.util.Arrays;

/**
 * @author guorui
 * @create 2022-05-11-15:16
 */
public class FileInputStream extends InputStream {

    @Override
    public int read() {
        System.out.println("低性能方式读取了一个字节a");
        return 97;
    }

    @Override
    public int read(byte[] buffer) {
        buffer[0] = 97;
        buffer[1] = 98;
        buffer[2] = 99;
        System.out.println("低性能方式读取了一个字节数组" + Arrays.toString(buffer));
        return 3;
    }
}
