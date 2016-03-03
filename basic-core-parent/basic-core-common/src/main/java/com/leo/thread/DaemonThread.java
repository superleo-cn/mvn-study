package com.leo.thread;

/**
 * Created by superleo on 3/3/16.
 */
public class DaemonThread extends Thread {

    public DaemonThread() {
        setDaemon(true);
    }

    public void run() {
        System.out.println("Daemon Thread? " + isDaemon());
        while (true) {
            try {
                sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("Woke up");
        }
    }

    public static void main(String a[]) {
        DaemonThread dt = new DaemonThread();
        dt.start();
        try {
            dt.join();
        } catch (Exception ex) {
        }
    }
}