package com.leo.projectEuler;

/**
 * Created by superleo on 3/25/16.
 */
public class Palindrome_04 {
    public static void main(String[] args) {
        int i = 999;
        int j = 998;
        while (i > 1 && j > 1) {
            int num = i * j;
            if (isPalindrome(num)) {
                System.out.println(num);
                System.out.println(i + ", " + j);
                break;
            }
            if (i == 1) {
                j = j - 1;
            } else {
                i = i - 1;
            }
        }
    }

    public static boolean isPalindrome(int val) {
        String myStr = String.valueOf(val);
        int length = myStr.length();
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            if (myStr.charAt(i) == myStr.charAt(length - i - 1)) {

            } else {
                return false;
            }

        }
        return true;
    }
}
