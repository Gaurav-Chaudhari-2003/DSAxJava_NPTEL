package nptel.W6_L1_QueueUsingJCF;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        /*
         * ==============================================
         * 1. PriorityQueue (Default: Natural Ordering)
         * ==============================================
         * - Stores elements in natural order (alphabetical / ascending numbers).
         * - Does NOT guarantee insertion order.
         */
        Queue<String> queue = new PriorityQueue<>();

        // Adding elements
        queue.add("Tommy");   // add() -> throws exception if fails
        queue.offer("Jayesh"); // offer() -> returns false if fails
        queue.add("Gaurav");
        queue.offer("Raj");
        queue.add("Jay");

        System.out.println("PriorityQueue (Natural Order): " + queue);

        // Accessing head element
        System.out.println("Head using element(): " + queue.element()); // exception if empty
        System.out.println("Head using peek(): " + queue.peek());       // null if empty

        // Removing elements
        System.out.println("Removed using remove(): " + queue.remove());
        System.out.println("Removed using poll(): " + queue.poll());
        System.out.println("After removals: " + queue);

        // Iterating PriorityQueue
        System.out.println("Iterating over PriorityQueue:");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println();


        /*
         * ==============================================
         * 2. LinkedList as Queue
         * ==============================================
         * - Maintains insertion order.
         * - Can work as Queue (FIFO) or Deque (Double-Ended Queue).
         */
        Queue<String> linkedQueue = new LinkedList<>(queue);
        linkedQueue.add("Rohit");
        linkedQueue.offer("Sagar");

        System.out.println("LinkedList Queue: " + linkedQueue);

        // Special LinkedList methods
        System.out.println("Peek first: " + ((LinkedList<String>) linkedQueue).peekFirst());
        System.out.println("Peek last: " + ((LinkedList<String>) linkedQueue).peekLast());

        ((LinkedList<String>) linkedQueue).addFirst("Start");
        ((LinkedList<String>) linkedQueue).addLast("End");
        System.out.println("After addFirst & addLast: " + linkedQueue);

        ((LinkedList<String>) linkedQueue).removeFirst();
        ((LinkedList<String>) linkedQueue).removeLast();
        System.out.println("After removeFirst & removeLast: " + linkedQueue);
        System.out.println();


        /*
         * ==============================================
         * 3. BlockingQueue (ArrayBlockingQueue)
         * ==============================================
         * - Thread-safe queue with fixed capacity.
         * - Used in Producer-Consumer problems.
         */
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // Adding elements
        blockingQueue.add("Tommy");
        blockingQueue.offer("Jayesh");
        try {
            blockingQueue.put("Raj"); // waits if full
            blockingQueue.offer("Gaurav", 2, TimeUnit.SECONDS); // waits for 2 sec if full
        } catch (Exception e) {
            System.out.println("Unable to add: " + e);
        }
        System.out.println("BlockingQueue: " + blockingQueue);

        // Removing elements
        blockingQueue.remove();
        blockingQueue.poll();
        try {
            blockingQueue.take(); // waits if empty
            blockingQueue.poll(2, TimeUnit.SECONDS); // waits for 2 sec if empty
        } catch (InterruptedException e) {
            System.out.println("Unable to remove: " + e);
        }
        System.out.println("BlockingQueue after removals: " + blockingQueue);
        System.out.println();


        /*
         * ==============================================
         * 4. Array to Queue and Queue to Array
         * ==============================================
         */
        String[] stringArray = {"10", "20", "30", "40"};
        Queue<String> queue1 = new LinkedList<>();
        Collections.addAll(queue1, stringArray);  // Array -> Queue
        System.out.println("Queue from Array: " + queue1);

        String[] stringArray1 = queue1.toArray(new String[0]); // Queue -> Array
        System.out.println("Array from Queue: " + Arrays.toString(stringArray1));
        System.out.println();


        /*
         * ==============================================
         * 5. Deque (ArrayDeque)
         * ==============================================
         * - Double-ended queue.
         * - Faster than LinkedList.
         */
        Deque<String> deque = new ArrayDeque<>();
        deque.add("10");
        deque.add("20");
        deque.add("30");

        // Insert at both ends
        deque.addFirst("Front");
        deque.addLast("Back");
        System.out.println("Deque after addFirst & addLast: " + deque);

        // Access both ends
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Remove from both ends
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removeFirst & removeLast: " + deque);
    }
}
