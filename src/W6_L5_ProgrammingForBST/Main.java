package W6_L5_ProgrammingForBST;

class BST<T extends Comparable<T>> {
    Node<T> root;
    BST() { root = null; }

    static class Node<T> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node<T> insert(Node<T> root, T data){
        if(root == null) return new Node<>(data);
        if(data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data); // left
        } else if(data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data); //right
        }
        return root;
    }
    public final void insert(T data) {
        root = insert(root, data);
    }

    public final void printInorder() {
        printInorderHelper(root);
        System.out.println();
    }
    private void printInorderHelper(Node<T> root) {
        if(root == null) return;
//        System.out.printf(root.data + " ");       // Pre-Order Traversal
        printInorderHelper(root.left);
        System.out.printf(root.data + " ");         // In-Order Traversal
        printInorderHelper(root.right);
//        System.out.printf(root.data + " ");       // Post-Order Traversal

    }

    private Node<T> inorderSuccessor(Node<T> root) {
        while(root.left != null) {
            root = root.left;
        } return root;
    }
    private Node<T> deleteNodeHelper(Node<T> root, T data) {
        if(root == null) return null;

        if(data.compareTo(root.data) < 0) {
            root.left = deleteNodeHelper(root.left, data);
        } else if(data.compareTo(root.data) > 0) {
            root.right = deleteNodeHelper(root.right, data);
        } else {
            // The node to be deleted is found

            // Case 1: No child (leaf)
            if (root.left == null && root.right == null) return null;

                // Case 2: One child
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // Case 2: Two Child
                Node<T> minNode = inorderSuccessor(root.right);
                root.data = minNode.data;
                root.right = deleteNodeHelper(root.right, minNode.data);
            }
        }

        return root;
    }
    public final void deleteNode(T data) {
        this.root = deleteNodeHelper(this.root, data);
    }

    private boolean searchInBST(Node<T> root, T data) {
        while (root != null) {
            int cmp = data.compareTo(root.data);
            if (cmp == 0) return true;
            root = (cmp < 0) ? root.left : root.right;
        }
        return false;
    }
    public boolean isPresent(T data) {
        return searchInBST(root, data);
    }
}

public class Main {
    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        integerBST.insert(10);
        integerBST.insert(20);
        integerBST.insert(70);
        integerBST.insert(40);
        integerBST.insert(30);
        integerBST.insert(5);
        integerBST.insert(60);
        integerBST.printInorder();

        integerBST.deleteNode(40);
        integerBST.printInorder();

        System.out.println("\n\tIs 40 present in BST?\n\t-> " +  integerBST.isPresent(40));
        System.out.println("\n\tIs 70 present in BST?\n\t-> " +  integerBST.isPresent(70));
    }
}
