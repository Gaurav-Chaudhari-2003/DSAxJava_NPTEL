package nptel.W7_L3_ProgrammingForHeapTree;

public class Heap<T extends Comparable<T>>{
    public T[] heap;
    public final int maxSize;
    public int top = 1;  // Start at 1 for simplicity

    public Heap(T[] heap, int maxSize) {
        this.heap = heap;
        this.maxSize = maxSize;
    }

    public final int parent(int position) {
        return position / 2;
    }

    public final int leftChild(int position) {
        return 2 * position;
    }

    public final int rightChild(int position) {
        return 2 * position + 1;
    }

    public final boolean isLeaf(int position) {
        return leftChild(position) >= top;
    }

    public final void swap(int position1, int position2) {
        T temp = heap[position1];
        heap[position1] = heap[position2];
        heap[position2] = temp;
    }

    public final void print() {
        for (int i = 1; i <= (maxSize - 1) / 2 -1; i++) {
            System.out.print("Parent: " + heap[i]);
            if (leftChild(i) < top && heap[leftChild(i)] != null)
                System.out.print(" | Left Child: " + heap[leftChild(i)]);
            if (rightChild(i) < top && heap[rightChild(i)] != null)
                System.out.print(" | Right Child: " + heap[rightChild(i)]);
            System.out.println();
        }
    }
}
