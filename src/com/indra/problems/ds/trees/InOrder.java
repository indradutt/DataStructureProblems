package com.indra.problems.ds.trees;

import java.util.Stack;

/**
 * Indra Dutt
 * Iterative traversal
 */
public class InOrder {

    public void inorder(BTree tree) {
        Stack<Node> stack = new Stack<>();

        if (tree.root == null) {
            return;
        }

        Node node = tree.root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.println(node.data);

            if (node.right != null) {
                node = node.right;

                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
}
