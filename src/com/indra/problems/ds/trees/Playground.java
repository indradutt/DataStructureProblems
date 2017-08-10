package com.indra.problems.ds.trees;

import com.indra.problems.ds.trees.BTree;
import com.indra.problems.ds.trees.Node;
import com.indra.problems.ds.trees.PreOrder;

/**
 * Indra Dutt
 */
public class Playground {

    public static void main(String[] args) {
        //String out = new ConvertNumber().convertTo("0501");
        //System.out.println(out);
        iterativeInorder();
    }

    private static void iterativeInorder() {
        Node r = new Node(11);
        BTree tree = new BTree(r);
        r.left = new Node(7);
        r.right = new Node(15);

        r.left.left = new Node(2);
        r.left.right = new Node(9);

        r.left.left.left = new Node(1);
        r.left.left.right = new Node(3);

        r.left.right.left = new Node(8);
        r.left.right.right = new Node(10);

        r.right.left = new Node(14);
        r.right.right = new Node(17);

        r.right.left.left = new Node(13);
        r.right.right.right = new Node(18);

        //new InOrder().inorder(tree);
        new PreOrder().preOrder(tree);
    }
}