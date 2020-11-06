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
    public void setShouldIncrementSizeWhenKeyNew() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("USA", 200);
        assertEquals(2, table.size());
    }

    @Test
    public void capacityShouldIncrementWhenNewKeys() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("USA", 200);
        table.set("Canada", 300);
        table.set("France", 400);
        int capacity = (int)getField(table, "capacity");
        assertEquals(8, capacity);
    }

    @Test
    public void getShouldReturnValue() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("USA", 200);
        Integer value = table.get("Mexico");
        assertEquals((Integer)100, value);
    }

    @Test
    public void getShouldReturnValueAfterResizing() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("USA", 200);
        Integer value1 = table.get("Mexico");
        table.set("Canada", 300);
        table.set("France", 400);
        Integer value2 = table.get("Mexico");
        assertEquals((Integer)100, value1);
        assertEquals((Integer)100, value2);
    }

    @Test
    public void tableShouldNotAllowDuplicates() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("Mexico", 200);
        assertEquals(1, table.size());
    }

    @Test
    public void getShouldReturnLastUpdate() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        table.set("Mexico", 200);
        Integer value = table.get("Mexico");
        assertEquals((Integer)200, value);
    }

    @Test
    public void getShouldReturnNullIfKeyNotFound() {
        table = new HashTable<String, Integer>(4);
        table.set("Mexico", 100);
        Integer value = table.get("USA");
        assertEquals(null, value);
    }
}