package nptel.W5_L5_QueueImplementation;


import java.util.LinkedList;

class ArrayQueue<T> {
    T[] data;
    int front, rear;
    int length;

    ArrayQueue(T[] data) {
        this.data = data;
        this.length = data.length;
        front = 0;
        rear = length - 1;
    }

    boolean isEmpty() {
        if (front > rear) System.out.println("Queue is empty");
        return front > rear;
    }

    void print() {
        System.out.println();
        if (isEmpty()) return;

        for (int i = front; i <= rear; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println();
    }

    void enqueue(T element){
        if(rear >= length-1){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        data[rear] = element;
    }

    void dequeue(){
        if (isEmpty()) return;

        data[front] = null;
        front++;
    }
}

class LinkedQueue<T> {
    LinkedList<T> linkedList;

    LinkedQueue() {
        linkedList = new LinkedList<>();
    }

    boolean isEmpty(){
        return linkedList.isEmpty();
    }

    void enqueue(T element){
        linkedList.addLast(element);
    }

    void dequeue(){
        if (isEmpty()) return;
        linkedList.removeFirst();
    }


    void print(){
        for (T t : linkedList) {
            System.out.print(t + " <- ");
        }
        System.out.println();
    }

}

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"10", "20", "30", "40"};

        ArrayQueue<String> queue = new ArrayQueue<>(stringArray);

        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.print();


        System.out.println();
        System.out.println();

        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("1");
        linkedQueue.enqueue("2");
        linkedQueue.enqueue("3");
        linkedQueue.print();
        linkedQueue.dequeue();
        linkedQueue.print();
        linkedQueue.enqueue("4");
        linkedQueue.print();
    }
}
