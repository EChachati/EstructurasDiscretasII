package tests;

import algorithms.Kruskal;
import graph.Graph;
import graph.Link;
import graph.Node;
import graph.Predefined;

import java.util.Arrays;
import java.util.Vector;

public class TestKruskal {

    public static Graph ciclycGraphNumber1() {
        final Node[] nodeArray = {
                new Node(50, 250),  // 0
                new Node(200, 50),  // 1
                new Node(200, 400), // 2
                new Node(300, 50),  // 3
                new Node(250, 250), // 4
                new Node(400, 150), // 5
                new Node(300, 400), // 6
                new Node(400, 350)  // 7
        };
        final Link[] linkArray = {
                new Link(nodeArray[0], nodeArray[2], 8),  // 0,2
                new Link(nodeArray[1], nodeArray[3], 4),  // 1,3
                new Link(nodeArray[2], nodeArray[4], 5),  // 2,4
                new Link(nodeArray[3], nodeArray[5], 5),  // 3,5
                new Link(nodeArray[4], nodeArray[3], 5),  // 4,3
                new Link(nodeArray[5], nodeArray[7], 4),  // 5,7
                new Link(nodeArray[6], nodeArray[4], 2),  // 6,4
                new Link(nodeArray[6], nodeArray[7], 5),  // 6,7
        };
        return new Graph(new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }

    public static Graph notCyclicgraphNumber1() {
        final Node[] nodeArray = {
                new Node(250,50),   // 0
                new Node(50, 150),  // 1
                new Node(250,250),  // 2
                new Node(100,400),  // 3
                new Node(400, 400), // 4
                new Node(450, 150)  // 5
        };
        final Link[] linkArray = {
                new Link(nodeArray[0], nodeArray[5], 14), // 0,5
                new Link(nodeArray[2], nodeArray[3], 11), // 2,3
                //new Link(nodeArray[4], nodeArray[3], 6),  // 4,3
                new Link(nodeArray[5], nodeArray[4], 9)   // 5,4
        };
        return new Graph(new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }

    public static Graph notCyclicgraphNumber2() {
        final Node[] nodeArray = {
                new Node(250,50),   // 0
                new Node(50, 150),  // 1
                new Node(250,250),  // 2
                new Node(100,400),  // 3
                new Node(400, 400), // 4
                new Node(450, 150)  // 5
        };
        final Link[] linkArray = {
                new Link(nodeArray[0], nodeArray[5], 14), // 0,5
                new Link(nodeArray[2], nodeArray[3], 11), // 2,3
                new Link(nodeArray[4], nodeArray[3], 6),  // 4,3
                new Link(nodeArray[5], nodeArray[4], 9)   // 5,4
        };
        return new Graph(new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }


    public static boolean testIsCycle(){
        Vector<Boolean> ret = new Vector<>();
        Vector<Graph> graphs = new Vector<>();
        graphs.add(notCyclicgraphNumber2());
        graphs.add(Predefined.graphNumber1());
        graphs.add(Predefined.graphNumber2());
        graphs.add(Predefined.graphNumber3());
        graphs.add(notCyclicgraphNumber1());
        graphs.add(ciclycGraphNumber1());
        ret.add(!Kruskal.isCycle(graphs.get(0).getLinkList()));
        ret.add(Kruskal.isCycle(graphs.get(1).getLinkList()));
        ret.add(Kruskal.isCycle(graphs.get(2).getLinkList()));
        ret.add(Kruskal.isCycle(graphs.get(3).getLinkList()));
        ret.add(!Kruskal.isCycle(graphs.get(4).getLinkList()));
        ret.add(Kruskal.isCycle(graphs.get(5).getLinkList()));

        System.out.println("Test 1: Should Return False.  Returns -> " + !ret.get(0));
        System.out.println("Test 2: Should Return True.  Returns -> " + ret.get(1));
        System.out.println("Test 3: Should Return True.  Returns -> " + ret.get(2));
        System.out.println("Test 4: Should Return False.  Returns -> " + !ret.get(3));
        System.out.println("Test 5: Should Return True.  Returns -> " + ret.get(4));

        for(Boolean B: ret){
            if (!B){ return false; }
        }
        return true;
    }

    public static boolean testKruskal(){
        Vector<Boolean> ret = new Vector<>();
        ret.add(Kruskal.minimumSpanningTree(Predefined.graphNumber1()) == 33);
        ret.add(Kruskal.minimumSpanningTree(Predefined.graphNumber2()) == 33);
        ret.add(Kruskal.minimumSpanningTree(Predefined.graphNumber3()) == 13);
        System.out.println("Test 1 Kruskal -> " + ret.get(0));
        System.out.println("Test 2 Kruskal -> " + ret.get(1));
        System.out.println("Test 3 Kruskal -> " + ret.get(2));

        for(Boolean B: ret){
            if (!B){ return false; }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(testIsCycle());
        System.out.println();
        System.out.println(testKruskal());
    }
}
