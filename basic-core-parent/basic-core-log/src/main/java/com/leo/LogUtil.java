package com.leo;


/**
 * Hello world!
 */
public class LogUtil {
    public static void log(String msg) {
        System.out.println("The log version is: " + VersionUtil.getMyVersion());
        System.out.println(msg);
    }
}
