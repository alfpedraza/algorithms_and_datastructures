package com.pedraza.algorithms;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    BinarySearch<Integer> search;

    @Test
    public void searchShouldReturnIndexWhenFound() {
        Integer[] data = new Integer[] { 9, 18, 23, 32, 50, 61 };
        assertBinarySearch(data, 61, 5);
    }

    @Test
    public void searchShouldReturnMinusOneWhenNotFound() {
        Integer[] data = new Integer[] { 9, 18, 23, 32, 50, 61 };
        assertBinarySearch(data, 33, -1);
    }

    @Test
    public void searchShouldReturnMinusOneWhenNotFoundOneItem() {
        Integer[] data = new Integer[] { 9 };
        assertBinarySearch(data, 2, -1);
    }

    @Test
    public void searchShouldReturnMinusOneWhenNotFoundEmptyItem() {
        Integer[] data = new Integer[] { };
        assertBinarySearch(data, 2, -1);
    }

    @Test
    public void searchShouldReturnWhenItemAtLeft() {
        Integer[] data = new Integer[] { 1, 2, 3, 4, 5 };
        assertBinarySearch(data, 2, 1);
    }

    @Test
    public void searchShouldReturnWhenItemAtRight() {
        Integer[] data = new Integer[] { 1, 2, 3, 4, 5 };
        assertBinarySearch(data, 4, 3);
    }

    @Test
    public void searchShouldReturnWhenItemAtMid() {
        Integer[] data = new Integer[] { 1, 2, 3, 4, 5 };
        assertBinarySearch(data, 3, 2);
    }

    private void assertBinarySearch(Integer[] data, int value, int expected) {
        search = new BinarySearch<Integer>(data);
        int actual = search.binarySearch(value);
        assertEquals(expected, actual);
    }
}