package W8_L1_GraphAlgorithms;

import java.util.List;

public class Graph<T extends Comparable> {
    private T firstNode;
    private int vertices;
    private List<Integer> adjencyList;
    private boolean isDirected;

    Graph() {

    }
}

class Node{
    private int value;
    private List<Node> connectedEdges;
}
