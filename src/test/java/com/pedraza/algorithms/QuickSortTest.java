package com.pedraza.algorithms;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {

    QuickSort<Integer> sort;

    @Test
    public void dataShouldBeSortedWithSomeItems() {
        Integer[] data = new Integer[] { 50, 23, 9, 18, 61, 32 };
        Integer[] expected = new Integer[] { 9, 18, 23, 32, 50, 61 };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithSomeItems2() {
        Integer[] data = new Integer[] { 23, 50, 60, 18, 2, 32 };
        Integer[] expected = new Integer[] { 2, 18, 23, 32, 50, 60 };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithEmptyItems() {
        Integer[] data = new Integer[] { };
        Integer[] expected = new Integer[] { };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithOneItem() {
        Integer[] data = new Integer[] { 4 };
        Integer[] expected = new Integer[] { 4 };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithTwoItems() {
        Integer[] data = new Integer[] { 4, 2 };
        Integer[] expected = new Integer[] { 2, 4 };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithOddItems() {
        Integer[] data = new Integer[] { 4, 2, 10, 5, 7, 13, 1 };
        Integer[] expected = new Integer[] { 1, 2, 4, 5, 7, 10, 13 };
        assertQuickSort(data, expected);
    }

    @Test
    public void dataShouldBeSortedWithEvenItems() {
        Integer[] data = new Integer[] { 4, 2, 10, 5, 7, 1 };
        Integer[] expected = new Integer[] { 1, 2, 4, 5, 7, 10 };
        assertQuickSort(data, expected);
    }

    private void assertQuickSort(Integer[] data, Integer[] expected) {
        sort = new QuickSort<Integer>(data);
        sort.quickSort();
        Integer[] actual = sort.data();
        assertArrayEquals(expected, actual);
    }
}