package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class ArbitraryTreeToChildSumTree {

    /*
     * 1. go till leaves, check the parent. if less than sum of leaves increase the value
     * 2. if parent sum is higher than leaves add the weight to one of the leaves
     * 3. check for other children
     */

    public void maintainChildSumProperty(Node root) {
        maintainChildSumPropertyUtil(root);
    }

    private int maintainChildSumPropertyUtil(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return node.data;

        int leftWeight = maintainChildSumPropertyUtil(node.left);
        int rightWeight = maintainChildSumPropertyUtil(node.right);

        if (node.data < leftWeight + rightWeight) {
            node.data = leftWeight + rightWeight;
        } else {
            addWeight(node, node.data - leftWeight - rightWeight);
        }

        return node.data;
    }

    private void addWeight(Node node, int delta) {
        if (node == null || (node.left == null && node.right == null) ) return;

        if (node.left != null) {
            node.left.data += delta;
            addWeight(node.left, delta);
        } else {
            node.right.data += delta;
            addWeight(node.right, delta);
        }
    }
}
