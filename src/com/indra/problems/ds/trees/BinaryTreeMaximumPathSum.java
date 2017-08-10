package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 * http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
 */
public class BinaryTreeMaximumPathSum {

    public int findMaxPathSum(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMaxPathSumUtil(root, max);
        return max[0];
    }

    int findMaxPathSumUtil(Node node, int[] max) {
        if (node == null) return 0;

        int leftSum = findMaxPathSumUtil(node.left, max);
        int rightSum = findMaxPathSumUtil(node.right, max);

        int currentSum = Math.max(node.data, Math.max(leftSum + node.data, rightSum + node.data));
        max[0] = Math.max(currentSum, leftSum + rightSum + node.data);

        return currentSum;
    }
}
