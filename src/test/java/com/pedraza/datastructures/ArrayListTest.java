package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class ArrayListTest extends TestBase {

    ArrayList<Integer> list;

    @Test
    public void capacityShouldDefault() {
        list = new ArrayList<Integer>(16);
        assertEquals(16, list.capacity());
    }

    @Test
    public void sizeShouldbeIncreasedWhenAddElement() {
        list = new ArrayList<Integer>(16);
        list.add(2);
        assertEquals(1, list.size());
    }

    @Test
    public void sizeShouldUpdateWhenAddAndRemoveItems() {
        list = new ArrayList<Integer>(16);
        list.add(2);
        list.add(2);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void sizeShouldUpdateWhenAddAndRemoveItems2() {
        list = new ArrayList<Integer>(16);
        list.add(1); 
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)3, list.get(1));
    }

    @Test
    public void capacityShouldUpdateWhenAddItems() {
        list = new ArrayList<Integer>(2);
        list.add(2);
        list.add(2);
        list.add(2);
        assertEquals(4, list.capacity());
    }
}