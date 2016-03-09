package com.leo.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by superleo on 3/3/16.
 */
public class WaitNotifyThread {

    public static Integer OBJECT = new Integer(10);
    public BlockingQueue<String> queue;

    public WaitNotifyThread(int size) {
        queue = new BlockingQueue(size);
    }

    static class WaitThred extends Thread {

        private BlockingQueue<String> lock;

        public WaitThred(BlockingQueue<String> lock) {
            this.lock = lock;
        }

        public void run() {
            while (true) {
                try {
                    System.out.println("WaitNotifyThread Start to wait...");
                    lock.put(String.valueOf(new Random().nextInt()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NotifyThred extends Thread {

        private BlockingQueue<String> lock;

        public NotifyThred(BlockingQueue<String> lock) {
            this.lock = lock;
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    System.out.println("NotifyThred Start to wait..." + lock.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String arg[]) {
        WaitNotifyThread dt = new WaitNotifyThread(2);
        WaitThred a = new WaitThred(dt.queue);
        NotifyThred b = new NotifyThred(dt.queue);
        a.start();
        b.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static class BlockingQueue<T> {

        private Queue<T> queue = new LinkedList<T>();
        private int capacity;

        public BlockingQueue(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void put(T element) throws InterruptedException {
            while (queue.size() == capacity) {
                wait();
            }

            queue.add(element);
            notify(); // notifyAll() for multiple producer/consumer threads
        }

        public synchronized T take() throws InterruptedException {
            while (queue.isEmpty()) {
                wait();
            }

            T item = queue.remove();
            notify(); // notifyAll() for multiple producer/consumer threads
            return item;
        }
    }


}