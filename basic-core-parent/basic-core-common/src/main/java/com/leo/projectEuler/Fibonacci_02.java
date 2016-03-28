package com.leo.projectEuler;

/**
 * Created by superleo on 3/25/16.
 */
public class Fibonacci_02 {

    static class Fibonacci {

        public Fibonacci() {
        }


        public int getNum(int i) {
            if (i == 1 || i == 2) {
                return i;
            } else {
                return getNum(i - 2) + getNum(i - 1);
            }
        }

    }

    public static void main(String[] args) {
        int MAX = 4_000_000;
        int count = 1;
        long sum = 0;
        Fibonacci f = new Fibonacci();
        do {
            int val = f.getNum(count++);
            if (val >= MAX) {
                break;
            }
            if (val % 2 == 0) {
                sum += val;
            }
        } while (true);
        System.out.println(sum);
    }

}
