package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class LargestBSTInBinTree {
    private class Info {
        int size;
        int min;
        int max;
        boolean isBst;

        public Info() {
            size = 0; min = Integer.MIN_VALUE; max = Integer.MAX_VALUE; isBst = false;
        }
    }

    public int getLargestBST(Node root) {
        Info info = findBST(root);
        return info.size;
    }

    private Info findBST(Node node) {
        if (node == null) return new Info();

        Info leftSubTreeInfo = findBST(node.left);
        Info rightSubTreeInfo = findBST(node.right);

        Info rootInfo = new Info();

        if (!leftSubTreeInfo.isBst || !rightSubTreeInfo.isBst
                || leftSubTreeInfo.max > node.data || rightSubTreeInfo.min <= node.data) {
            rootInfo.isBst = false;
            rootInfo.size = Math.max(leftSubTreeInfo.size, rightSubTreeInfo.size);
            return rootInfo;
        }
        rootInfo.isBst = true;
        rootInfo.size = leftSubTreeInfo.size + rightSubTreeInfo.size + 1;

        rootInfo.min = node.left != null ? leftSubTreeInfo.min : node.data;
        rootInfo.max = node.right != null ? rightSubTreeInfo.max : node.data;

        return rootInfo;
    }
}