package edu.ti.collections.list.queue;

import edu.ti.collections.list.dataobj.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testNewQueueIsEmpty() {
        Queue<Double> queue = new Queue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAddOneIsNotEmptyHasSizeOne() {
        Queue<Integer> queue =  new Queue<>();
        Integer student = new Integer(4);
        queue.enqueue(student);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    public void testSizeUpAndDown() {
        Queue<String> stringQueue = new Queue<>();
        assertEquals(0, stringQueue.size());
        stringQueue.enqueue("Foo");
        assertEquals(1, stringQueue.size());
        stringQueue.enqueue("Bar");
        assertEquals(2, stringQueue.size());
        stringQueue.enqueue("Baz");
        assertEquals(3, stringQueue.size());
        stringQueue.dequeue();
        assertEquals(2, stringQueue.size());
        stringQueue.dequeue();
        assertEquals(1, stringQueue.size());
        stringQueue.dequeue();
        assertEquals(0, stringQueue.size());

        assertTrue(stringQueue.isEmpty());
    }

    @Test
    public void testDequeIsEmpty() {
        Queue<Person> queue = new Queue<>();
        Person alice = new Person("Smith", "Alice");
        Person bob = new Person("Smith", "Bob");
        Person carl = new Person("Jones", "Carl");
        Person doris = new Person("Jones", "Doris");
        queue.enqueue(alice);
        queue.enqueue(bob);
        queue.enqueue(carl);
        queue.enqueue(doris);

        Person personDequeued = queue.dequeue();
        assertEquals(alice, personDequeued);

        personDequeued = queue.dequeue();
        assertEquals(bob, personDequeued);

        personDequeued = queue.dequeue();
        assertEquals(carl, personDequeued);

        personDequeued = queue.dequeue();
        assertEquals(doris, personDequeued);
    }
}