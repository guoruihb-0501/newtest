package com.future.test;

/**
 * @author guorui
 * @create 2022-05-11-15:22
 */
public class BufferedInputStream extends InputStream {
    private InputStream is;

    public BufferedInputStream(InputStream is) {
        this.is = is;
    }

    @Override
    public int read() {
        //扩展原始类功能的语句
        System.out.println("提供了8K缓冲区，提升了性能");
        //调用原始类方法，不改变原始类
        return is.read();
    }

    @Override
    public int read(byte[] buffer) {
        //扩展原始类功能的语句
        System.out.println("提供了8K缓冲区，提升了性能");
        //调用原始类方法，不改变原始类
        return is.read(buffer);
    }
}
