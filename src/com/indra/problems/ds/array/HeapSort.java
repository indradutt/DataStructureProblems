package com.indra.problems.ds.array;

/**
 * Indra Dutt
 */
public class HeapSort {

    public void heapSort(int[] input) {
        int size =  input.length;

        for (int i = 0; i < size; i++) {
            heapify(input, size, i);
        }
        // remove nodes and heapify again
        for (int i = size - 1; i >= 0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            heapify(input, i, 0);
        }
    }

    private void heapify(int[] input, int n, int index) {
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && input[left] > input[largest]) {
            largest = left;
        }
        if (right < n && input[right] > input[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = input[largest];
            input[largest] = input[index];
            input[index] = temp;

            heapify(input, n, largest);
        }

    }
}
