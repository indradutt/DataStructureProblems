package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class LowestCommonAncestorBinTree {

    public Node findLCA(Node root, Node one, Node two) {
        if (root == null) return null;

        if (root.data == one.data || root.data == two.data) {
            return root;
        }

        Node n1 = findLCA(root.left, one, two);
        Node n2 = findLCA(root.right, one, two);

        if (n1 == null && n2 == null) return null;
        else if (n1 == null || n2 == null) return (n1 == null ? n2 : n1);
        else return root;
    }
}