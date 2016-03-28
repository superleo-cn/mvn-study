package com.leo.projectEuler;

/**
 * Created by superleo on 3/25/16.
 */
public class Multiples3And5_01 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
