package com.indra.problems.ds.graph;

import java.util.Iterator;

/**
 * Indra Dutt
 */
public class DepthFirstSearch {
    private IGraph graph;

    public void dfs(IGraph graph, int root) {
        System.out.println();
        this.graph = graph;
        boolean[] visited = new boolean[graph.numV];
        traverseDFS(root, visited);
    }

    // in case of disconnected graphs
    public void dfs(IGraph graph) {
        System.out.println();
        this.graph = graph;
        boolean[] visited = new boolean[graph.numV];

        for (int i = 0; i < graph.numV; i++) {
            if (!visited[i]) {
                traverseDFS(i, visited);
            }
        }
    }

    private void traverseDFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> iterator = graph.adj[v].iterator();

        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                traverseDFS(n, visited);
            }
        }
    }
}
