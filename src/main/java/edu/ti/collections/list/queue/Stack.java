package edu.ti.collections.list.queue;

import edu.ti.collections.list.linked.LinkedList;

//a Stack is LIFO
public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
        T retval;
        retval = list.remove(0);
        return retval;
    }

    public void push(T obj) {
        list.insert(obj);
    }
}
