package com.leo.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by superleo on 7/3/16.
 */
public class QuickSort {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i < j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int SIZE = 7;
        int MAX = 20;
        //int[] numbers = new int[SIZE];
        int[] numbers = new int[]{23, 43, 1, 3, 5, 10};
//        Random generator = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = generator.nextInt(MAX);
//        }
        QuickSort sorter = new QuickSort();
        sorter.sort(numbers);
        for (Integer i : numbers) {
            System.out.println(i + " ");
        }
    }
}
