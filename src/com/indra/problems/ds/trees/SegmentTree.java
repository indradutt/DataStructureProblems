package com.indra.problems.ds.trees;

/**
 * Indra Dutt
 */
public class SegmentTree {

    public int[] createSegmentTree(int[] input) {
        int height = (int)Math.ceil(Math.log(input.length)/Math.log(2));
        int size = (int)Math.pow(2, height + 1) - 1;
        int[] segmentTree = new int[size];
        constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);
        return segmentTree;
    }

    /**
     * Giving example to solve min through SegmentTree
     *
     * @param input input array
     * @param segment segment array, pre-constructed
     * @param low lower bound of input array
     * @param high upper bound of input array
     * @param pos current position of element in input array
     */
    public void constructSegmentTree(int[] input, int[] segment, int low, int high, int pos) {
        if (low == high) {
            segment[pos] = input[low];
            return;
        }
        int mid = (high + low)/2;

        constructSegmentTree(input, segment, low, mid, 2 * pos + 1);// left sub tree
        constructSegmentTree(input, segment, mid + 1, high, 2 * pos + 2);// right sub tree

        segment[pos] = Math.min(segment[2 * pos + 1], segment[2 * pos + 2]);
    }

    public int rangeQuery(int[] segmentTree, int qLow, int qHigh, int len) {
        return rangeQuery(segmentTree, qLow, qHigh, 0, len - 1, 0);
    }

    private int rangeQuery(int[] segmentTree, int qLow, int qHigh, int low, int high, int pos) {
        //if total overlap, return value
        if (qLow <= low && qHigh >= high) {
            return segmentTree[pos];
        }
        //if no overlap, return MAX
        if (qLow > high || qHigh < low) {
            return Integer.MAX_VALUE;
        }

        int mid = (high + low)/2;
        return Math.min(rangeQuery(segmentTree, qLow, qHigh, low, mid, 2 * pos + 1), rangeQuery(segmentTree, qLow, qHigh, mid + 1, high, 2 * pos + 2));
    }
}