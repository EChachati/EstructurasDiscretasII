package algorithms;

import evaluation_1.graph.Link;
import evaluation_1.graph.Graph;
import evaluation_1.graph.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Dijkstra {

    public String shortestPathDijkstra(Graph graph, int start, int objective) {
        Node actual = graph.getNodeList().get(start);
        Vector<Node> unvisited = new Vector<>(graph.getNodeList());
        Map<Integer, Integer[]> cost = new HashMap<>(); // NodeID ->  0 ShortestPathFromStart, 1 PreviousVertexID

        for (Node node : graph.getNodeList()) {
            cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
        }

        cost.put(start, new Integer[]{0, -1});

        while (unvisited.contains(graph.getNodeList().get(objective))) {

            for (Node n : actual.getAllAccessNodes()) {
                int visitedId = n.getIdentifier();
                Link linkActualToN = (Link) actual.undirectedMap.get(n.getIdentifier())[1];
                int shortestPathFromStart = cost.get(actual.getIdentifier())[0] + linkActualToN.getDistance();

                if (cost.get(n.getIdentifier())[0] > shortestPathFromStart || cost.get(n.getIdentifier())[1] == -1) {
                    cost.put(visitedId, new Integer[]{shortestPathFromStart, actual.getIdentifier()});
                }
            }

            int lowerDistance = Integer.MAX_VALUE;
            for (Node k : unvisited) {
                if (cost.get(k.getIdentifier())[0] < lowerDistance) {
                    actual = k;
                    lowerDistance = cost.get(k.getIdentifier())[0];
                }
            }
            unvisited.removeElement(actual);
        }

        StringBuilder str = new StringBuilder("" + objective);
        while (objective != start) {
            objective = cost.get(objective)[1];
            str.insert(0, objective + " -> ");
        }
        return str.toString();
    }


}
