package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class BSTOneChildPreOrderTraversal {

    public boolean isOneChildBST(int[] input) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < input.length - 1; i++) {
            if (input[i] >= min && input[i] < max) {
                if (input[i + 1] < input[i]) {
                    max = input[i];
                } else {
                    min = input[i];
                }
            } else
                return false;
        }
        if (input[input.length - 1] < max && input[input.length - 1] > min) {
            return true;
        }
        return false;
    }
}
