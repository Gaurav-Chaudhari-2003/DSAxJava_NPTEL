package nptel.W7_L5_DFS_BFS;

import java.util.List;

public class Graph {
    Node node;

    Graph() {

    }
}

class Node<T>{
    T value;
    List<T> connectedNodes;

    public Node(T value) {
        this.value = value;
    }

    
}
