package algorithms;

import graph.Graph;
import graph.Link;

import java.util.Collection;
import java.util.Comparator;
import java.util.Vector;

public class Kruskal {

    public void minimumSpanningTree(Graph graph){
        // Nodos Conectados
        // Nodos Desconectados
        // Links Usados
        // Links Sin Usar, Ordenados

        //Se realiza mientras !NodosDesconectados.isEmpty
    }

    public Collection<Link> sortLinksByDistance(Vector<Link> links) {
        links.sort(new LinkComparator());
        return links;
    }

    static class LinkComparator implements Comparator<Link> {
        public int compare(Link a, Link b){
            return a.getDistance() - b.getDistance();
        }
    }
}
