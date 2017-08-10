package com.indra.problems.ds.trees;

import java.util.Stack;

/**
 * Indra Dutt
 */
public class PreOrder {

    public void preOrder(BTree tree) {
        if (tree.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(tree.root);

        while (stack.size() > 0) {
            Node node = stack.pop();
            System.out.println(node.data);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
    }
}
