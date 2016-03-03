package com.leo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by superleo on 3/3/16.
 */
public class MyListTest {

    // static final List<String> list = new ArrayList<>();
    static final List<String> list = new CopyOnWriteArrayList();

    static {
        list.add("a");
        list.add("b");
        list.add("c");
    }

    public static void main(String[] args) {
        System.out.println("Started.");
        new MyThreadA(list).start();
        new MyThreadB(list).start();
        new MyThreadC(list).start();
        System.out.println("Finished.");
    }

    static class MyThreadA extends Thread {

        final List<String> myMap;

        public MyThreadA(List<String> map) {
            myMap = map;
        }

        public void run() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (myMap != null) {
                myMap.remove("b");
                System.out.println(myMap.size());
                for (String entry : myMap) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry);
                }
            }
        }
    }

    static class MyThreadC extends Thread {

        final List<String> myMap;

        public MyThreadC(List<String> map) {
            myMap = map;
        }

        public void run() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (myMap != null) {
                myMap.add("d");
                System.out.println(myMap.size());
                for (String entry : myMap) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry);
                }
            }
        }
    }

    static class MyThreadB extends Thread {

        final List<String> myMap;

        public MyThreadB(List<String> map) {
            myMap = map;
        }

        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (myMap != null) {
                // Map<String, String> m = Collections.synchronizedMap(myMap);
                //Map<String, String> m = new ConcurrentHashMap(myMap);

                // Map<String, String> m = myMap;
//                myMap.entrySet().stream().forEach(e -> System.out.println(e.getKey()));
                System.out.println();
                for (String entry : myMap) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry);
                }

            }
        }
    }
}
