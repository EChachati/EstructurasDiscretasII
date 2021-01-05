package algorithms;

import graph.Graph;
import graph.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BFS {
    public static void BFS(Graph graph, int node) {
        StringBuilder BFS = new StringBuilder("[ ");
        Node actual = graph.getNodeList().get(node);
        Queue<Node> queue = new LinkedList();
        Vector<Boolean> visited = new Vector<>();
        for (int i = 0, nodesSize = graph.getNodeList().size(); i < nodesSize; i++) { visited.add(false); }
        queue.add(actual);
        visited.set(actual.getIdentifier(), true);
        while (visited.contains(false)) {
            for (Node n : actual.getAllAccessNodes()) {
                if (!queue.contains(n) && !visited.get(n.getIdentifier())) {
                    queue.add(n);
                }
            }
            actual = queue.poll();
            assert actual != null;
            visited.set(actual.getIdentifier(), true);
            BFS.append(actual.getIdentifier()).append(" ");
            System.out.println(BFS);
        }
        BFS.append("]");
        System.out.println(BFS);
    }
}
