package W7_L4_HuffmanTree_WeightedTree;

import java.util.*;

public class WeightedTree<T extends Comparable<T>> {
    private final Vector<T> treeArray = new Vector<>();
    private final Vector<T> huffmanTree = new Vector<>();

    public Vector<T> getTreeArray() {
        return treeArray;
    }
    public Vector<T> getHuffmanTree() {
        return huffmanTree;
    }

    WeightedTree(T[] tree){
        Collections.addAll(this.treeArray, tree);
        Collections.addAll(this.huffmanTree, tree);
        convertToHuffman();
    }

    private void convertToHuffman() {
        if (treeArray.isEmpty()) return;
        quickSort(0, treeArray.size() - 1);

        int treeSize = treeArray.size();

        for(int i = 0; i < treeSize-1; i++) {
            int num1 = (Integer) treeArray.removeFirst();
            int num2 = (Integer) treeArray.removeFirst();
            treeArray.addFirst((T) Integer.valueOf(num1+num2));
            huffmanTree.addLast((T) Integer.valueOf(num2+num1));
            quickSort(0, treeArray.size() - 1);
        }

        huffmanTree.sort(Collections.reverseOrder());
    }

    private int partition(int low, int high) {
        T pivot = treeArray.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (treeArray.get(j).compareTo(pivot) <= 0) {
                i++;
                T temp = treeArray.get(i);
                treeArray.set(i, treeArray.get(j));
                treeArray.set(j, temp);
            }
        }

        T temp = treeArray.get(i + 1);
        treeArray.set(i + 1, treeArray.get(high));
        treeArray.set(high, temp);

        return i + 1;
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
}
