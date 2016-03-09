package com.leo.algorithm;

/**
 * Created by superleo on 7/3/16.
 */
public class Fibonacci {

    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    public int calculate(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return calculate(n - 2) + calculate(n - 1);
        }
    }

    public int start() {
        return calculate(this.n);
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci(11);
        System.out.println(fb.start());
    }
}
