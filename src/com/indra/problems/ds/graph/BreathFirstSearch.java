package com.indra.problems.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Indra Dutt
 */
public class BreathFirstSearch {

    public void bfs(IGraph graph, int root) {
        // all visited node are false by default
        boolean visited[] = new boolean[graph.numV];
        // output data resides here
        LinkedList<Integer> queue = new LinkedList<>();

        visited[root] = true;
        queue.add(root);

        while (queue.size() != 0) {
            root = queue.poll();
            System.out.print(root + " ");

            Iterator<Integer> iterator = graph.adj[root].listIterator();

            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
