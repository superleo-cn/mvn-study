package com.leo.projectEuler;

/**
 * Created by superleo on 3/25/16.
 */
public class LargestPrimeFactor_03 {
    public static void main(String[] args) {
        long MAX = 600851475143L;
        for (int i = 2; i * i <= MAX; i++) {
            while (MAX % i == 0) {
                System.out.println(i);
                MAX = MAX / i;
            }
        }

        if (MAX > 1) System.out.println(MAX);
        else System.out.println();
    }
}
