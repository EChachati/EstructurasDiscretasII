package algorithms;

import java.awt.Color;
import graph.Canvas;
import graph.Graph;
import graph.Link;
import graph.Node;

import java.util.*;

import static algorithms.Dijkstra.waitFor;

public class Kruskal {

    public static int minimumSpanningTree(Canvas canvas){
        // Accepted = GREEN  ***  Unaccepted = RED   ***  Checking = Yellow
        Graph graph = canvas.getGraph();
        //waitFor(canvas);
        Vector<Link> usedLinks = new Vector<>();
        Vector<Link> unusedLinks = new Vector<>(sortLinksByDistance(graph.getLinkList()));

        int cost = 0;
        int x = 0;
        while(!unusedLinks.isEmpty() && x < 30){
            x++;
            usedLinks.add(unusedLinks.firstElement());
            unusedLinks.remove(0);
            usedLinks.lastElement().setColor(Color.YELLOW);
            //waitFor(canvas);
            if (isCycle(usedLinks)){
                usedLinks.lastElement().setColor(Color.RED);
                usedLinks.remove(usedLinks.lastElement());
            } else {
                usedLinks.lastElement().setColor(Color.GREEN);
            }
            //waitFor(canvas);
        }
        for(Link link: usedLinks){
            cost += link.getDistance();
        }
        return cost;

    }

    public static int minimumSpanningTree(Graph graph){
        Vector<Link> usedLinks = new Vector<>();
        Vector<Link> unusedLinks = new Vector<>(sortLinksByDistance(graph.getLinkList()));
        int cost = 0;
        int x = 0;
        while(!unusedLinks.isEmpty() && x < 30){
            x++;
            usedLinks.add(unusedLinks.firstElement());
            unusedLinks.remove(0);
            if (isCycle(usedLinks)){
                usedLinks.lastElement().setColor(Color.RED);
                usedLinks.remove(usedLinks.lastElement());
            }
        }
        for(Link link: usedLinks){
            cost += link.getDistance();
        }
        return cost;
    }

    public static boolean isCycle(Vector<Link> links) {
        Vector<Link> usedLinks = new Vector<>(links);
        Link newLink = usedLinks.lastElement();
        Queue<Node> nodeQueueA = new LinkedList<>();
        Vector<Node> visitedNodes = new Vector<>();
        Node actualA = newLink.node.get(0);
        nodeQueueA.offer(actualA);

        while(!nodeQueueA.isEmpty()){

            actualA = nodeQueueA.poll();
            if(visitedNodes.contains(actualA)){return true;}
            Vector<Link> actualALinks = removeAllNotIn(actualA.getAllAccessLinks(), usedLinks);

            for(Link link: actualALinks){
                if(link.node.get(0) != actualA){
                    if (!visitedNodes.contains(link.node.get(0))){
                    nodeQueueA.offer(link.node.get(0));
                    }
                } else {
                    if (!visitedNodes.contains(link.node.get(1))){
                        nodeQueueA.offer(link.node.get(1));
                    }
                }
                usedLinks.remove(link);
            }
            visitedNodes.add(actualA);
        }
        return false;
    }


    private static Vector<Link> removeAllNotIn(Collection<Link> original,Collection<Link> keept){
        Vector<Link> ret = new Vector<>();
        for (Link l: original){
            if(keept.contains(l)){
                ret.add(l);
            }
        }
        return ret;
    }

    private static Collection<Link> sortLinksByDistance(Vector<Link> links) {
        links.sort(new LinkComparator());
        return links;
    }

    static class LinkComparator implements Comparator<Link> {
        public int compare(Link a, Link b){
            return a.getDistance() - b.getDistance();
        }
    }
}
