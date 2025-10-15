package W7_L3_ProgrammingForHeapTree;

public class MinHeap extends Heap {

    public MinHeap(Comparable[] heap) {
        super(heap, 11);
    }


    private void bubbleUp(int position) {
        int parentPosition = parent(position);
        while (position > 1 && heap[position].compareTo(heap[parentPosition]) < 0) {        // < 0: current node’s value is smaller than its parent’s value
            swap(position, parentPosition);
            position = parentPosition;
            parentPosition = parent(position);
        }
    }


    public final void insert(Comparable node) {
        if (top >= maxSize) {
            return; // Heap is full
        }
        heap[top] = node;
        bubbleUp(top);
        top++;
    }

    private void bubbleDown(int position) {
        int left = leftChild(position);
        int right = rightChild(position);
        int smallest = position;

        // Compare with left child
        if (left < top && heap[left].compareTo(heap[smallest]) < 0)
            smallest = left;

        // Compare with right child
        if (right < top && heap[right].compareTo(heap[smallest]) < 0)
            smallest = right;

        // If smallest is not the current node → swap and continue
        if (smallest != position) {
            swap(position, smallest);
            bubbleDown(smallest);
        }
    }

    public void delete() {
        if (top == 1) {
            System.out.println("Heap is empty");
        } else {
            heap[1] = heap[top-1];
            heap[top-1] = null;
            top--;
            bubbleDown(1);
        }
    }
}
