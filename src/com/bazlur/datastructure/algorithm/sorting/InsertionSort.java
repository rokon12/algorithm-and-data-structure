package com.bazlur.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/6/15.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 3, 0, 1, 41, 23};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int j;

            for (j = i - 1; j >= 0 && element < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = element;
        }
    }
}
