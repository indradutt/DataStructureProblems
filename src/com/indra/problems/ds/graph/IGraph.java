package com.indra.problems.ds.graph;

import java.util.LinkedList;

/**
 * Indra Dutt
 */
public class IGraph {
    public int numV;
    public LinkedList<Integer> adj[];

    public IGraph (int vertices) {
        numV = vertices;
        adj = new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
