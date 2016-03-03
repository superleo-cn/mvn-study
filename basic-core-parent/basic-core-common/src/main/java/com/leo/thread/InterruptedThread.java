package com.leo.thread;

/**
 * Created by superleo on 3/3/16.
 */
public class InterruptedThread {
    public static void main(String args[])  {
        Thread t = new MyThread();
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}

class MyThread extends Thread {
    public void run() {
//        while (!this.interrupted()) {
//            ;
//        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Interrupted");
    }
}