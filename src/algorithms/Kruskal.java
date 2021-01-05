package algorithms;

import graph.Graph;
import graph.Link;
import graph.Node;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Vector;

public class Kruskal {

    public void minimumSpanningTree(Graph graph){
        // Nodos Conectados
        // Nodos Desconectados
        // Links Usados
        // Links Sin Usar, Ordenados

        //Se realiza mientras !NodosDesconectados.isEmpty
            // Se Revisa el Link con costo mas bajo que no forme un ciclo

    }

    private boolean makesCycle(Vector<Link> usedLinks, Graph graph) {
        Vector<Node> visitedNodes = new Vector<>();
        Vector<Node> unvisitedNodes = graph.getNodeList();
        //Node actual = graph.getNodeList().get(0);
        for (Node actual: graph.getNodeList()){
            visitedNodes.add(actual);
            for (Map.Entry<Integer, Object[]> access: actual.undirectedMap.entrySet()){
                Link linkTo = (Link)access.getValue()[1];
                if (){}
            }
        }
        return true;
    }

    private Collection<Link> sortLinksByDistance(Vector<Link> links) {
        links.sort(new LinkComparator());
        return links;
    }

    static class LinkComparator implements Comparator<Link> {
        public int compare(Link a, Link b){
            return a.getDistance() - b.getDistance();
        }
    }
}

// https://www.youtube.com/watch?v=ivcbaIhrcsE