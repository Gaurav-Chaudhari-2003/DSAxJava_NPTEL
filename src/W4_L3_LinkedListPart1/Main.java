package W4_L3_LinkedListPart1;

class JLinkedList<T> {
    private final Node headNode;  // dummy head node

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    JLinkedList() {
        headNode = new Node(null); // dummy node
    }

    // Print list
    public void printList() {
        Node current = headNode.next;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Print list in reverse order
    public void printListReverse() {
        System.out.println("Linked List in reverse order: ");
        printReverseHelper(headNode.next);
        System.out.println("NULL");
    }

    private void printReverseHelper(Node next) {
        if (next == null) return;
        printReverseHelper(next.next);
        System.out.print(next.data + " -> ");
    }

    // Insert at front
    public void insertFront(T data) {
        Node newNode = new Node(data);
        newNode.next = headNode.next;
        headNode.next = newNode;
    }

    // Insert at last
    public void insertLast(T data) {
        Node newNode = new Node(data);
        Node ptr = headNode;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    // Insert at index
    public void insertAt(int index, T data) {
        Node newNode = new Node(data);
        Node ptr = headNode;
        int i = 0;
        while (ptr.next != null && i < index) {
            ptr = ptr.next;
            i++;
        }
        newNode.next = ptr.next;
        ptr.next = newNode;
    }

    // Delete first node
    public void deleteFirst() {
        if (headNode.next != null) {
            headNode.next = headNode.next.next;
        }
    }

    // Delete last node
    public void deleteLast() {
        if (headNode.next == null) return; // empty list
        Node ptr = headNode;
        while (ptr.next != null && ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }

    // Delete at index
    public void deleteAt(int index) {
        Node ptr = headNode;
        int i = 0;
        while (ptr.next != null && i < index) {
            ptr = ptr.next;
            i++;
        }
        if (ptr.next != null) {
            ptr.next = ptr.next.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        JLinkedList<Object> list = new JLinkedList<>();

        // Insert operations
        list.insertFront(10);
        list.insertLast(20);
        list.insertFront("Gaurav");
        list.insertLast(true);
        list.insertAt(1, "Jayesh");

        System.out.println("Linked List after insertions:");
        list.printList();

        list.printListReverse();

        // Delete operations
        list.deleteFirst();
        list.deleteLast();
        list.deleteAt(2);

        System.out.println("Linked List after deletions:");
        list.printList();

        list.printListReverse();
    }
}
