package com.leo.algorithm.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hubo on 3/14/2016.
 */
public class FindConsecutiveArray {

    public static int[] longestConsecutiveSequence(int[] a) {
        int first = Integer.MAX_VALUE; // the first number of the maximum consecutive sequence
        int length = 0; // the length of the maximum consecutive sequence
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i : a) {
            if (!table.containsKey(i)) {
                int start = i;
                int end = i;
                if (table.containsKey(i + 1) && table.get(i + 1) >= i + 1) {
                    end = table.get(i + 1);
                    table.remove(i + 1);
                    table.remove(end);
                }
                if (table.containsKey(i - 1) && table.get(i - 1) <= i - 1) {
                    start = table.get(i - 1);
                    table.remove(i - 1);
                    table.remove(start);
                }
                table.put(start, end);
                table.put(end, start);
                if (end - start + 1 > length) {
                    first = start;
                    length = end - start + 1;
                }
            }
        }
        System.out.println(table);
        System.out.println(length);
        int[] s = new int[length];
        for (int i = 0; i < length; i++) s[i] = first + i;
        return s;
    }

    public static void LongestContiguousSubArr(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int f = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int beg = num;
            int end = num;

            if (map.containsKey(num))
                continue;//already processed

            map.put(num, num);

            int numm1 = num - 1;
            int nump1 = num + 1;

            if (map.containsKey(numm1))
                beg = map.get(numm1);
            if (map.containsKey(nump1))
                end = map.get(nump1);
//
//            int temp = map.get(beg);
//            map.put(beg, map.get(end));
//            map.put(end, temp);

            if (f - l <= end - beg) {
                f = beg;
                l = end;
            }
        }

        for (int i = f; i <= l; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2};
        int[] arr = {1, 6, 10, 4, 7, 9, 5};
//        int[] result = longestConsecutiveSequence(arr);
//        System.out.println("The result is: ");
//        for (int i : result) {
//            System.out.println(i);
//        }
        System.out.println("The result is: ");
        LongestContiguousSubArr(arr);
    }
}
