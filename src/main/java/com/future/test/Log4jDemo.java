package com.future.test;


import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;

/**
 * @author guorui
 * @create 2022-05-24-15:59
 */
public class Log4jDemo {
    public static Logger LOGGER = Logger.getLogger("Log4jDemo.class");
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
