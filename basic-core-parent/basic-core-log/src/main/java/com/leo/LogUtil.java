package com.leo;


/**
 * Hello world!
 */
public class LogUtil {
    public static void main(String[] msg) {
        System.out.println("The log version is: " + VersionUtil.getMyVersion());
        System.out.println(msg);

        int i = 10;
        for (int j = 0; j < 3; j++) {
            i = i << 1;
        }
        System.out.println(i);
    }

    public static String log(String msg) {
        return msg;
    }
}
