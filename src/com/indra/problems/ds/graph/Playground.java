package com.indra.problems.ds.graph;

/**
 * Indra Dutt
 */
public class Playground {

    public static void main(String[] args) {
        IGraph graph = buildGraph();

        new BreathFirstSearch().bfs(graph,  2);
        new DepthFirstSearch().dfs(graph, 2);
    }

    private static IGraph buildGraph() {
        IGraph g = new IGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        return g;
    }
}
