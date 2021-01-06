package algorithms;

import graph.Graph;
import graph.Node;

import java.util.Vector;

public class DFS {
    public static void depthFirstSearch(Graph graph){
        Vector<Node> visitedNodes = new Vector<>();
        Vector<Node> unvisitedNodes = graph.getNodeList();
        Node actual = graph.getNodeList().get(0);

        visitedNodes.add(actual);



    }
}
