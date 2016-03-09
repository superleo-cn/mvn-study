package com.leo.algorithm;

import java.util.Arrays;

/**
 * Created by superleo on 7/3/16.
 */
public class ReverseString {

    private String str;
    private char[] result;

    public ReverseString(String str) {
        this.str = str;
        result = new char[str.length()];
    }

    public void calculate(int size) {
        if (size > -1) {
            result[size] = str.charAt(str.length() - size - 1);
            calculate(size - 1);
        }
    }

    public String start() {
        calculate(this.str.length() - 1);
        return Arrays.toString(this.result);
    }

    public static void main(String[] args) {
        ReverseString fb = new ReverseString("aBDEF");
        System.out.println(fb.start());
    }
}
