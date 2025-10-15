package W7_L3_ProgrammingForHeapTree;

public class MaxHeap extends Heap {

    public MaxHeap(Comparable[] heap) {
        super(heap, 11);
    }


    private void bubbleUp(int position) {
        int parentPosition = parent(position);
        while (position > 1 && heap[position].compareTo(heap[parentPosition]) > 0) {        // < 0: current node’s value is smaller than its parent’s value
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
        int largest = position;

        if(left < top && heap[left].compareTo(heap[largest]) > 0)
            largest = left;

        if (right < top && heap[right].compareTo(heap[largest]) > 0)
            largest = right;

        if (largest != position) {
            swap(position, largest);
            bubbleDown(largest);
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
