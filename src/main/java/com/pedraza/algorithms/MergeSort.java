package com.pedraza.algorithms;

public class MergeSort<T extends Comparable<T>> {

    private T[] data;

    public MergeSort(T[] data) {
        this.data = data;
    }

    public T[] data() { return data; }

    public void mergeSort() {
        mergeSort(0, data.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {

        // Create left and right arrays and fill them.
        int size1 = mid - low + 1;
        int size2 = high - mid;
        T[] left  = createArray(size1);
        T[] right = createArray(size2);
        for (int i = 0; i < size1; i++) left[i]  = data[low + i];
        for (int i = 0; i < size2; i++) right[i] = data[mid + 1 + i];

        // Fill array with sorted data.
        int i = 0;
        int j = 0;
        int k = low;
        while (i < size1 && j < size2) {
            if (left[i].compareTo(right[j]) <= 0) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining items to the array.
        while (i < size1) { data[k] = left[i];  k++; i++; }
        while (j < size2) { data[k] = right[j]; k++; j++; }
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) { return (T[]) new Comparable[size]; }
}
