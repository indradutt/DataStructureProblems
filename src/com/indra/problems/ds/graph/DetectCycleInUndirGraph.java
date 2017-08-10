package com.indra.problems.ds.graph;

import java.util.Iterator;

/**
 * Indra Dutt
 */
public class DetectCycleInUndirGraph {

    private IGraph graph;

    public boolean isCyclic(IGraph graph) {
        this.graph = graph;

        boolean[] visited = new boolean[graph.numV];
        for (int i = 0; i < graph.numV; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycleUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> iterator = graph.adj[v].listIterator();

        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                if (detectCycleUtil(n, visited, v))
                    return true;
            } else if (n != parent) {
                return true;
            }
        }
        return false;
    }
}