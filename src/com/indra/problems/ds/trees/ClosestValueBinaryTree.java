package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class ClosestValueBinaryTree {

    public void findClosestValue(Node root, int target) {
        int result = target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        result = findClosestValueUtil(root, target, result);
    }

    private int findClosestValueUtil(Node node, int target, int result) {
        if (node == null) return result;

        if (target == node.data) {
            return node.data;
        }

        if (Math.abs(node.data - target) < Math.abs(result - target) ) {
            result = node.data;
        }
        if (target > node.data) {
            return findClosestValueUtil(node.right, target, result);
        } else {
            return findClosestValueUtil(node.left, target, result);
        }
    }
}
