package edu.ti.collections.list.linked;

public class RecursionLinkedList<T> {
    private class Node {
        T payload;
        Node next = null;

        public Node(T payload) {
            this.payload = payload;
        }

        public T getPayload() {
            return payload;
        }

        public void setPayload(T payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    // TODO keep track of endnode in remove, write a test to ensure you kept track of endnode.
    //endnode never changes, its at the end, we add to the front.
    Node endNode = null;

    public RecursionLinkedList() {
        // nothing
    }

    public RecursionLinkedList(T payload) {
        head = new Node(payload);
        endNode = head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return sizeHelper(head);
    }

    private int sizeHelper(Node node){
        int size = (node == null)? 0 : 1 + sizeHelper(node.next);
        return size;
    }

    //while head != null
    public Node end() {
        return lastNode(endNode);
    }

    private Node lastNode(Node node){
        Node lastNode = (node==null)?null:(node.next == null)?node:lastNode(node.next);
        return lastNode;
    }

    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(head);
        if(head == null){
            endNode = newNode;
        }
        head = newNode;
    }

    public void append(T object) {
        Node newNode = new Node(object);
        if(head == null) {
            head = newNode;
            endNode = newNode;
        } else {
            endNode.setNext(newNode);
            endNode = newNode;
        }
    }

    public T get(int n) {
        T requestedObject = null;
        if (n < size()) {
           requestedObject = getRequestedObject(n, head).getPayload();
        }return requestedObject;
    }

    private Node getRequestedObject(int n, Node node){
        Node requestedNode = (n==0)?node:getRequestedObject(n-1, node.next);
        return requestedNode;
    }

    public T remove(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            while (n-- > 0) {
                beforeRequestedNode = requestedNode;
                requestedNode = requestedNode.getNext();
            }
            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
            if(requestedNode.getNext() == null){
                endNode = beforeRequestedNode;
            }
        }
        return requestedObject;
    }

    public T remove(T object) {
        T requestedObject = null;
        if (head != null) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            boolean foundNode = false;
            do {
                if (requestedNode.getPayload().equals(object)) {
                    foundNode = true;
                } else {
                    beforeRequestedNode = requestedNode;
                    requestedNode = requestedNode.getNext();
                }
            } while (!foundNode && requestedNode.getNext() != null);

            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
            if(requestedNode.getNext() == null){
                endNode = beforeRequestedNode;
            }
        }
        return requestedObject;
    }
}
