package com.indra.problems.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Indra Dutt
 */
public class ReachableInDirectedGraph {

    private IGraph graph;

    // taking bfs to determine
    public boolean isReachable(int source, int dest) {
        this.graph = graph;

        boolean[] visited = new boolean[graph.numV];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (queue.size() > 0) {
            source = queue.poll();

            Iterator<Integer> iterator = graph.adj[source].listIterator();
            while (iterator.hasNext()) {
                int node = iterator.next();
                if (node == dest) {
                    return true;
                }

                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }
}