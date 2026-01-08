package nptel.W7_L3_ProgrammingForHeapTree;


public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];

        MaxHeap heap = new MaxHeap(arr);
//        MinHeap heap = new MinHeap(arr);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.print();
        System.out.println("\n\n");
        heap.delete();
        heap.print();
    }
}
