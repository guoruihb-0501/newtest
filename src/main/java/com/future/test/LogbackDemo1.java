package com.future.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guorui
 * @create 2022-05-23-19:46
 */
public class LogbackDemo1 {
    public static Logger LOGGER = LoggerFactory.getLogger("LogbackDemo1.class");  //获取logger对象
    public static void main(String[] args) {

        try {
            LOGGER.info("记录info级别日志");
            LOGGER.debug("记录debug级别日志");
            int a = 10;
            int b = 0;
            LOGGER.trace("a = " + a);
            LOGGER.trace("b = " + b);
            System.out.println(a / b);

        } catch (Exception e) {
            LOGGER.error("功能出现异常" + e);
        }


    }
}
