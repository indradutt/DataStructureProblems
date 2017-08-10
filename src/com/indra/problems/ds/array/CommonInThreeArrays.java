package com.indra.problems.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Indra Dutt
 */
public class CommonInThreeArrays {

    public static List<Integer> findCommon(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList<Integer> out = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0) return out;

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                out.add(arr1[i]);
                i++;
                j++;
                k++;

            }
            else if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;
            }
            else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;
            }
            else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                k++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        List<Integer> out = findCommon(ar1, ar2, ar3);
        System.out.print(Arrays.asList(out));
    }
}
