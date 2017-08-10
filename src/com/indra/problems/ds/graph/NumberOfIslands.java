package com.indra.problems.ds.graph;

/**
 * Indra Dutt
 */
public class NumberOfIslands {
    private int M = 5, N = 5;

    boolean isSafe(int matrix[][], int row, int column, boolean visited[][]) {
        return (row >= 0 && row < M && column >= 0 && column < N
        && matrix[row][column] == 1 && !visited[row][column]);
    }


}
