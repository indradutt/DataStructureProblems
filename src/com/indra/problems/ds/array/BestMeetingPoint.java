package com.indra.problems.ds.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Indra Dutt
 */
public class BestMeetingPoint {
    public class Point {
        int x, y;
    }

    public Point commonMeetingPoint(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return new Point();

        Point p = new Point();
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {     // row
            for (int j = 0; j < grid[0].length; j++) {  //column
                if (grid[i][j] == 1) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        Collections.sort(row);
        Collections.sort(column);
        p.x = row.get(row.size()/2);
        p.y = column.get(column.size()/2);
        return p;
    }

    public int minTotalDistance(int[][] grid) {
        Point p = commonMeetingPoint(grid);
        int distance = 0;
        for (int i = 0; i < grid.length; i++) {     // row
            for (int j = 0; j < grid[0].length; j++) {  //column
                if (grid[i][j] == 1) {
                    distance += Math.abs(p.x - i) + Math.abs(p.y - j);
                }
            }
        }
        return distance;
    }

    public static void main(String args[]) {
        BestMeetingPoint bmp = new BestMeetingPoint();
        int[][] grid = {{1, 0, 1, 0, 1}, {0, 0, 0, 0, 0},{0, 0, 1, 0, 0}};
        Point p = bmp.commonMeetingPoint(grid);
        System.out.println("x = "+p.x+", y = "+p.y);
        System.out.println(bmp.minTotalDistance(grid));
    }
}
