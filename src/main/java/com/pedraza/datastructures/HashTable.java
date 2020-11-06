package com.pedraza.datastructures;

@SuppressWarnings("unchecked")
public class HashTable<K,V> {

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

    public void set(K key, V value) {
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
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }
}