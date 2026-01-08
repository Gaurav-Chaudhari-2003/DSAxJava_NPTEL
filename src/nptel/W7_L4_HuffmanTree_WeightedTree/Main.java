package nptel.W7_L4_HuffmanTree_WeightedTree;

public class Main {
    public static void main(String[] args) {
        WeightedTree<Integer> weightedTree = new WeightedTree<>(new Integer[]{3, 3, 4, 5, 7});
        System.out.println(weightedTree.getOriginalTree());
        System.out.println(weightedTree.getHuffmanTree());
    }
}
