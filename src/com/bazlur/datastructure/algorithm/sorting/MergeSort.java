package com.bazlur.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/8/15.
 */
public class MergeSort {
    static int[] helpers;

    public static void main(String[] args) {
        int[] input = {4,5,3,7,1};
        sort(input);
        System.out.println(Arrays.toString(input));

    }

    private static void sort(int[] input) {
        helpers = new int[input.length];
        mergeSort(input, 0, input.length - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergeSort(a, low, middle);
            mergeSort(a, middle + 1, high);

            merge(a, low, middle, high);
        }
    }

    private static void merge(int[] a, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helpers[i] = a[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helpers[i] <= helpers[j]) {
                a[k] = helpers[i];
                i++;
            } else {
                a[k] = helpers[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            a[k] = helpers[i];
            k++;
            i++;
        }

        while (j <= high) {
            a[k] = helpers[j];
            k++;
            j++;
        }

    }
}
