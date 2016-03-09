package com.leo.algorithm;

/**
 * Created by superleo on 7/3/16.
 */
public class Hanoi {
    private int size;

    private char x = 'x';
    private char y = 'y';
    private char z = 'z';

    public Hanoi(int n) {
        this.size = n;
    }

    public void move(int n, char from, char mid, char to) {
        if (n == 1) {
            System.out.println((n) + " From " + from + " to " + to);
        } else {
            move(n - 1, from, to, mid);
            System.out.println((n) + " From " + from + " to " + to);
            move(n - 1, mid, from, to);
        }
    }

    public void start() {
        move(size, x, y, z);
    }

    public static void main(String[] args) {
        Hanoi fb = new Hanoi(3);
        fb.start();
    }

}
