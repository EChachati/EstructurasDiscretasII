package graph;

import java.util.Arrays;
import java.util.Vector;

public class Predefined {

    public static Graph graphNumber1() {
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
                new Link(nodeArray[0], nodeArray[1], 10), // 0,1
                new Link(nodeArray[0], nodeArray[2], 8),  // 0,2
                new Link(nodeArray[1], nodeArray[3], 4),  // 1,3
                new Link(nodeArray[2], nodeArray[1], 8),  // 2,1
                new Link(nodeArray[2], nodeArray[4], 5),  // 2,4
                new Link(nodeArray[3], nodeArray[5], 5),  // 3,5
                new Link(nodeArray[4], nodeArray[3], 5),  // 4,3
                new Link(nodeArray[4], nodeArray[5], 7),  // 4,5
                new Link(nodeArray[5], nodeArray[6], 12), // 5,6
                new Link(nodeArray[5], nodeArray[7], 4),  // 5,7
                new Link(nodeArray[6], nodeArray[2], 7),  // 6,2
                new Link(nodeArray[6], nodeArray[4], 2),  // 6,4
                new Link(nodeArray[6], nodeArray[7], 5),  // 6,7
        };
        return new Graph(new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }

    public static Graph graphNumber2() {
        final Node[] nodeArray = {
                new Node(250,50),   // 0
                new Node(50, 150),  // 1
                new Node(250,250),  // 2
                new Node(100,400),  // 3
                new Node(400, 400), // 4
                new Node(450, 150)  // 5
        };
        final Link[] linkArray = {
                new Link(nodeArray[0], nodeArray[1], 7),  // 0,1
                new Link(nodeArray[0], nodeArray[2], 9),  // 0,2
                new Link(nodeArray[0], nodeArray[5], 14), // 0,5
                new Link(nodeArray[1], nodeArray[2], 10), // 1,2
                new Link(nodeArray[1], nodeArray[3], 15), // 1,3
                new Link(nodeArray[2], nodeArray[3], 11), // 2,3
                new Link(nodeArray[2], nodeArray[5], 2),  // 2,5
                new Link(nodeArray[4], nodeArray[3], 6),  // 4,3
                new Link(nodeArray[5], nodeArray[4], 9)   // 5,4
        };
        return new Graph(new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }

    public static Graph graphNumber3() {
        final Node[] nodeArray = {
                new Node(200,50), // 0
                new Node(100,200), // 1
                new Node(300,200), // 2
                new Node(100,400), // 3
                new Node(300, 400) // 4
        };
        final Link[] linkArray = {
                new Link(nodeArray[0], nodeArray[1], 2),   // 0,1
                new Link(nodeArray[0], nodeArray[2], 1),   // 0,2
                new Link(nodeArray[0], nodeArray[4], 14),  // 0,4
                new Link(nodeArray[1], nodeArray[2], 3),   // 1,2
                new Link(nodeArray[1], nodeArray[3], 20),  // 1,3
                new Link(nodeArray[1], nodeArray[4], 13),  // 1,4
                new Link(nodeArray[2], nodeArray[4], 8),   // 2,4
                new Link(nodeArray[4], nodeArray[3], 2)    // 4,3
        };
        return new Graph( new Vector<>(Arrays.asList(nodeArray)), new Vector<>(Arrays.asList(linkArray)));
    }
}
