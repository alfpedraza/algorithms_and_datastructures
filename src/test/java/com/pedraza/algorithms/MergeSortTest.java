package com.pedraza.algorithms;

import static org.junit.Assert.*;
import org.junit.Test;

public class MergeSortTest {

    MergeSort<Integer> sort;

    @Test
    public void dataShouldBeSortedWithSomeItems() {
        Integer[] data = new Integer[] { 50, 23, 9, 18, 61, 32 };
        Integer[] expected = new Integer[] { 9, 18, 23, 32, 50, 61 };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithSomeItems2() {
        Integer[] data = new Integer[] { 23, 50, 60, 18, 2, 32 };
        Integer[] expected = new Integer[] { 2, 18, 23, 32, 50, 60 };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithEmptyItems() {
        Integer[] data = new Integer[] { };
        Integer[] expected = new Integer[] { };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithOneItem() {
        Integer[] data = new Integer[] { 4 };
        Integer[] expected = new Integer[] { 4 };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithTwoItems() {
        Integer[] data = new Integer[] { 4, 2 };
        Integer[] expected = new Integer[] { 2, 4 };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithOddItems() {
        Integer[] data = new Integer[] { 4, 2, 10, 5, 7, 13, 1 };
        Integer[] expected = new Integer[] { 1, 2, 4, 5, 7, 10, 13 };
        assertMergeSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithEvenItems() {
        Integer[] data = new Integer[] { 4, 2, 10, 5, 7, 1 };
        Integer[] expected = new Integer[] { 1, 2, 4, 5, 7, 10 };
        assertMergeSort(data, expected);
    }

    private void assertMergeSort(Integer[] data, Integer[] expected) {
        sort = new MergeSort<Integer>(data);
        sort.mergeSort();
        Integer[] actual = sort.data();
        assertArrayEquals(expected, actual);
    }
}