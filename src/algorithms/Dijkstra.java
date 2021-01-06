package algorithms;

import graph.Canvas;
import graph.Graph;
import graph.Link;
import graph.Node;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Dijkstra {

    public static String shortestPathDijkstra(Canvas canvas, int start, int objective) {
        Graph graph = canvas.getGraph();
        Node actual = graph.getNodeList().get(start);
        graph.getNodeList().get(objective).setColor(Color.green);
        Vector<Node> unvisited = new Vector<>(graph.getNodeList());
        Map<Integer, Integer[]> cost = new HashMap<>(); // NodeID ->  0 ShortestPathFromStart, 1 PreviousVertexID

        for (Node node : graph.getNodeList()) {
            cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
        }

        cost.put(start, new Integer[]{0, -1});

        while (unvisited.contains(graph.getNodeList().get(objective))) {
            //Actual = Pink   ***   Objective & Final Path = green  ***  Visited = Yellow
            actual.setColor(Color.PINK);
            waitFor(canvas);
            for (Node n : actual.getAllAccessNodes()) {
                int visitedId = n.getIdentifier();
                Link linkActualToN = (Link) actual.undirectedMap.get(n.getIdentifier())[1];
                int shortestPathFromStart = cost.get(actual.getIdentifier())[0] + linkActualToN.getDistance();

                if (cost.get(n.getIdentifier())[0] > shortestPathFromStart || cost.get(n.getIdentifier())[1] == -1) {
                    cost.put(visitedId, new Integer[]{shortestPathFromStart, actual.getIdentifier()});
                }
            }
            actual.setColor(Color.YELLOW);
            int lowerDistance = Integer.MAX_VALUE;
            for (Node k : unvisited) {
                if (cost.get(k.getIdentifier())[0] < lowerDistance) {
                    actual = k;
                    lowerDistance = cost.get(k.getIdentifier())[0];
                }
            }

            unvisited.removeElement(actual);
            actual.setColor(Color.PINK);
            waitFor(canvas);
        }
        StringBuilder str = new StringBuilder("" + objective);
        graph.getNodeList().get(start).setColor(Color.GREEN);
        while (objective != start) {
            graph.getNodeList().get(objective).setColor(Color.GREEN);
            objective = cost.get(objective)[1];
            str.insert(0, objective + " -> ");
        }
        waitFor(canvas);
        return str.toString();
    }

    private static void waitFor(Canvas canvas) {
        try {
            Thread.sleep(800);
            canvas.repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
