package graph;

import java.util.Arrays;
import java.util.Vector;

public class Predefined {

    public static Graph graphNumber1() {
        final Node[] nodeArray = {
                new Node(70, 350),  // 0
                new Node(280, 70),  // 1
                new Node(280, 560), // 2
                new Node(420, 70),  // 3
                new Node(350, 350), // 4
                new Node(560, 210), // 5
                new Node(420, 560), // 6
                new Node(560, 490)  // 7
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
                new Node(350,  70),   // 0
                new Node(70,  210),  // 1
                new Node(350, 350),  // 2
                new Node(140, 560),  // 3
                new Node(560, 560), // 4
                new Node(630, 210)  // 5
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
                new Node(280,  70), // 0
                new Node(140, 280), // 1
                new Node(420, 280), // 2
                new Node(140, 560), // 3
                new Node(420, 560)  // 4
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

    public static Graph SmallGraphNumber1() {
        // FOR JPANEL 290PXx290PX
        final Node[] nodeArray = {
                new Node(29, 147),  // 0
                new Node(118, 29),  // 1
                new Node(118, 235), // 2
                new Node(176, 29),  // 3
                new Node(147, 147), // 4
                new Node(235, 88), // 5
                new Node(176, 235), // 6
                new Node(235, 206)  // 7
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

    public static Graph smallGraphNumber2() {
        // FOR JPANEL 290x290
        final Node[] nodeArray = {
                new Node(147, 29),   // 0
                new Node(29, 88),  // 1
                new Node(147, 147),  // 2
                new Node(59, 235),  // 3
                new Node(235, 235), // 4
                new Node(265, 88)  // 5
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

    public static Graph SmallGraphNumber3() {
        final Node[] nodeArray = {
                new Node(118, 29), // 0
                new Node(59, 118), // 1
                new Node(176, 118), // 2
                new Node(59, 235), // 3
                new Node(176, 235)  // 4
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
