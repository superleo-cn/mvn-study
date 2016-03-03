package com.leo.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by superleo on 3/3/16.
 */
public class MyMapTest {

    //static final Map<String, String> map = new HashMap<>();
    static final Map<String, String> map = new ConcurrentHashMap();

    static {
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
    }

    public static void main(String[] args) {
        System.out.println("Started.");
        new MyThreadA(map).start();
        new MyThreadB(map).start();
        new MyThreadC(map).start();
        System.out.println("Finished.");
    }

    static class MyThreadA extends Thread {

        final Map<String, String> myMap;

        public MyThreadA(Map<String, String> map) {
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
                for (Map.Entry<String, String> entry : myMap.entrySet()) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry.getKey());
                }
            }
        }
    }

    static class MyThreadC extends Thread {

        final Map<String, String> myMap;

        public MyThreadC(Map<String, String> map) {
            myMap = map;
        }

        public void run() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (myMap != null) {
                myMap.put("d", "d");
                System.out.println(myMap.size());
                for (Map.Entry<String, String> entry : myMap.entrySet()) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry.getKey());
                }
            }
        }
    }

    static class MyThreadB extends Thread {

        final Map<String, String> myMap;

        public MyThreadB(Map<String, String> map) {
            myMap = map;
        }

        public void run() {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (myMap != null) {
                // Map<String, String> m = Collections.synchronizedMap(myMap);
                //Map<String, String> m = new ConcurrentHashMap(myMap);

                // Map<String, String> m = myMap;
//                myMap.entrySet().stream().forEach(e -> System.out.println(e.getKey()));
                System.out.println();
                for (Map.Entry<String, String> entry : myMap.entrySet()) {
                    System.out.println(Thread.currentThread().getId() + " : " + entry.getKey());
                }

            }
        }
    }
}
