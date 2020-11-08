package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashTableTest extends TestBase {

    HashTable<String, Integer> table;

    @Test
    public void capacityShouldDefault() {
        table = new HashTable<String, Integer>(4);
        int capacity = (int)getField(table, "capacity");
        assertEquals(4, capacity);
    }

    @Test
    public void putShouldIncrementSizeWhenKeyNew() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("USA", 200);
        assertEquals(2, table.size());
    }

    @Test
    public void capacityShouldIncrementWhenNewKeys() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("USA", 200);
        table.put("Canada", 300);
        table.put("France", 400);
        int capacity = (int)getField(table, "capacity");
        assertEquals(8, capacity);
    }

    @Test
    public void getShouldReturnValue() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("USA", 200);
        Integer value = table.get("Mexico");
        assertEquals((Integer)100, value);
    }

    @Test
    public void getShouldReturnValueAfterResizing() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("USA", 200);
        Integer value1 = table.get("Mexico");
        table.put("Canada", 300);
        table.put("France", 400);
        Integer value2 = table.get("Mexico");
        assertEquals((Integer)100, value1);
        assertEquals((Integer)100, value2);
    }

    @Test
    public void tableShouldNotAllowDuplicates() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("Mexico", 200);
        assertEquals(1, table.size());
    }

    @Test
    public void getShouldReturnLastUpdate() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        table.put("Mexico", 200);
        Integer value = table.get("Mexico");
        assertEquals((Integer)200, value);
    }

    @Test
    public void getShouldReturnNullIfKeyNotFound() {
        table = new HashTable<String, Integer>(4);
        table.put("Mexico", 100);
        Integer value = table.get("USA");
        assertEquals(null, value);
    }

    @Test
    public void iteratorShoudlReturnAllValues() {
        table = new HashTable<String, Integer>(8);
        table.put("Mexico", 100);
        table.put("USA", 200);
        table.put("Canada", 300);
        table.put("France", 400);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer value : table) {
            list.add(value);
        }
        assertEquals(4, list.size());
    }
}