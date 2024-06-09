package Circular_FIFO_Queue;


import java.util.ArrayList;
import java.util.List;

public class CircularFIFOQueue<T> {
    private List<T> queue;
    private int front; // Front of the queue
    private int rear; // Rear of the queue

    public CircularFIFOQueue() {
        queue = new ArrayList<>();
        front = 0;
        rear = -1;
    }

    public void enqueue(T element) {
        queue.add(element);
        rear = (rear + 1) % queue.size();
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue element.");
        }
        T removedElement = queue.get(front);
        queue.remove(front);
        if (isEmpty()) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + queue.size()) % queue.size();
        }
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek element.");
        }
        return queue.get(front);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        CircularFIFOQueue<Integer> myQueue = new CircularFIFOQueue<>();
        myQueue.enqueue(60);
        myQueue.enqueue(70);
        myQueue.enqueue(80);

        System.out.println("Front element: " + myQueue.peek());
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Is the queue empty? " + myQueue.isEmpty());
        System.out.println("Size of the queue: " + myQueue.size());
    }
}

