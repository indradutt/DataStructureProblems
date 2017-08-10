package com.indra.problems.ds.graph;

import java.util.Iterator;

/**
 * Indra Dutt
 */
public class DetectCycleInDirGraph {
    private IGraph graph;

    public boolean isCyclic(IGraph graph) {
        this.graph = graph;

        boolean[] visited = new boolean[graph.numV];
        boolean[] recursionStack = new boolean[graph.numV];

        for (int i = 0; i < graph.numV; i++) {
            if (detectCycleUtil(i, visited, recursionStack))
                return true;
        }
        return false;
    }

    private boolean detectCycleUtil(int v, boolean[] visited, boolean[] recStack) {
        if (!visited[v]) {
            visited[v] = true;
            recStack[v] = true;

            Iterator<Integer> iterator = graph.adj[v].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n] && detectCycleUtil(n, visited, recStack)) { // if the node has never been visited, check for cycle
                    return true;
                } else if (recStack[n]) {   // if the node has already been visited, check if this has been there in the stack
                    return true;
                }
            }
        }
        recStack[v] = false;
        return false;
    }
}