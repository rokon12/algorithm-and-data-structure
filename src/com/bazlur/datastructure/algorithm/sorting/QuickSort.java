package com.bazlur.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/8/15.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 3, 0, 1, 41, 23};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] a, int lowerIndex, int higherIndex) {
        int pivot = a[lowerIndex + (higherIndex - lowerIndex) / 2];

        int i = lowerIndex;
        int j = higherIndex;

        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;

            if (i <= j) {
                exchange(a, i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j) {
            quickSort(a, lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(a, i, higherIndex);
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
