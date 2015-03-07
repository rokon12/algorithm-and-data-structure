package com.bazlur.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/7/15.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 3, 0, 1, 41, 23};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        int i, j;
        int iMin;

        for (j = 0; j < a.length; j++) {

            iMin = j;
            for (i = j + 1; i < a.length; i++) {
                if (a[i] < a[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                swap(a, iMin, j);
            }
        }
    }

    private static void swap(int[] arr, int iMin, int i) {
        int temp = arr[iMin];
        arr[iMin] = arr[i];
        arr[i] = temp;
    }
}
