package com.leo.set;

import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by superleo on 3/3/16.
 */
public class MySetTest {


    public static void main(String[] args) {
        System.out.println("Started.");
        TreeSet ts = new TreeSet();
        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println("===");
        System.out.println(ts.higher("B"));
        System.out.println("===");
        ts.descendingIterator().forEachRemaining(e -> System.out.println(e));
        System.out.println("Finished.");
    }

}
