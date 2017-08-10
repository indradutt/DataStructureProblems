package com.indra.problems.ds.array;

import java.util.HashMap;

/**
 * Indra Dutt
 */
public class CheckConsecutiveNumbers {

    public static boolean hasConsecutive(int[] input) {
        if (input.length < 1) return false;

        HashMap<Integer, Boolean> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i< input.length; i++) {
            if (input[i] <= min) {
                min = input[i];
            }
            if (input[i] > max) {
                max = input[i];
            }
            map.put(input[i], false);
        }

        if (max - min + 1 != input.length) return false;

        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasConsecutive(new int[]{5, 4, 2, 3, 1, 6}));
        System.out.println(hasConsecutive(new int[]{83, 78, 80, 81, 79, 82}));
        System.out.println(hasConsecutive(new int[]{34, 23, 52, 12, 3}));
        System.out.println(hasConsecutive(new int[]{7, 6, 5, 5, 3, 4}));
    }
}
