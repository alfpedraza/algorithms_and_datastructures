package com.pedraza.algorithms;

public class QuickSort<T extends Comparable<T>> {
    private T[] data;

    public QuickSort(T[] data) {
        this.data = data;
    }

    public T[] data() { return data; }

    public void quickSort() {
        quickSort(0, data.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low >= high) return;
        int pivot = partition(low, high);
        quickSort(low, pivot - 1);
        quickSort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        T pivot = data[high];
        int i = low;
        for (int j = low; j < high; j++) {
            T current = data[j];
            if (current.compareTo(pivot) < 0) {
                swap(j, i);
                i++;
            }
        }
        swap(i, high);
        return i;
    }

    private void swap(int i, int j) {
        T tmp = data[j];
        data[j] = data[i];
        data[i] = tmp;
    }
}
