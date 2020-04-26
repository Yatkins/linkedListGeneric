package edu.ti.collections.list.queue;

import edu.ti.collections.list.linked.LinkedList;

public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(T obj) {
        list.append(obj);
    }

    public T dequeue() {
        return list.remove(0);
    }
}
