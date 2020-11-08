package com.pedraza.datastructures;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class HashTable<K,V> implements Iterable<V> {

    private class Node {
        public K key;
        public V value;
        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private static int DEFAULT_CAPACITY = 16;
    private static float DEFAULT_LOADFACTOR = 0.75F;

    private LinkedList<Node>[] data;
    private int capacity;
    private double loadFactor;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOADFACTOR);
    }

    public HashTable(int theCapacity) {
        this(theCapacity, DEFAULT_LOADFACTOR);
    }

    public HashTable(int theCapacity, float theLoadFactor) {
        data = (LinkedList<Node>[]) new LinkedList[theCapacity];
        capacity = theCapacity;
        loadFactor = theLoadFactor;
        size = 0;
    }

    public int size() { return size; }
    
    public V get(K key) {
        Node node = getNode(key);
        if (node != null) return node.value;
        return null;
    }

    public void put(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            ensureLoadFactor();
            addNode(key, value);
            size++;
        }
    }

    private void ensureLoadFactor() {
        float currentLoad = (float)(size + 1) / capacity;
        if (currentLoad >= loadFactor) {
            capacity = capacity * 2;
            LinkedList<Node>[] oldData = data;
            data = (LinkedList<Node>[]) new LinkedList[capacity];
            for (int i = 0; i < oldData.length; i++) {
                if (oldData[i] == null) continue;
                for (int j = 0; j < oldData[i].size(); j++) {
                    Node node = oldData[i].get(j);
                    addNode(node.key, node.value);
                    node = null;
                }
                oldData[i] = null;
            }
            oldData = null;
        }
    }

    private void addNode(K key, V value) {
        int index = getIndex(key);
        if (data[index] == null) data[index] = new LinkedList<Node>();
        LinkedList<Node> list = data[index];
        list.add(new Node(key, value));
    }

    private int getIndex(K key) {
        int index = key.hashCode() & 0x7FFFFFFF % capacity;
        return index;
    }

    private Node getNode(K key) {
        int index = getIndex(key);
        LinkedList<Node> list = data[index];
        if (list == null) return null;
        for (Node node : list) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Node> list = data[index];
        if (list == null) return;

        int i = 0;
        for (Node node : list) {
            if (node.key == key) {
                list.remove(i);
                if (list.size() == 0) {
                    list = null;
                    data[index] = null;
                }
                size--;
                return;
            }
            i++;
        }
    }

    public Iterator<V> iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator<V> {
        int nextIndex;
        Iterator<Node> listIterator;

        public HashTableIterator() {
            nextIndex = 0;
            listIterator = null;
        }

        public boolean hasNext() {
            if (listIterator != null && listIterator.hasNext()) return true;
            while(true) {
                nextIndex = nextKeyIndex();
                if (nextIndex == -1) return false;
                listIterator = data[nextIndex].iterator();
                if (listIterator.hasNext()) return true;
            }
        }

        public V next() {
            Node node = listIterator.next();
            if (!listIterator.hasNext()) {
                nextIndex++;
                listIterator = null;
            }
            return node.value;
        }

        private int nextKeyIndex() {
            if (nextIndex >= capacity) return -1;
            int index = nextIndex;
            while (index < capacity) {
                if (data[index] != null) return index;
                index++;
            }
            return -1;
        }
    }
}