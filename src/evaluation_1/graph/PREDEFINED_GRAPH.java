package evaluation_1.graph;

import java.util.Arrays;
import java.util.Vector;

public class PREDEFINED_GRAPH {

    private static final Node[] nodeArray_1 = {
            new Node(50, 250),  // 0
            new Node(200, 50),  // 1
            new Node(200, 400), // 2
            new Node(300, 50),  // 3
            new Node(250, 250), // 4
            new Node(400, 150), // 5
            new Node(300, 400), // 6
            new Node(400, 350)  // 7
    };

    private static final Link[] EdgeArray_1 = {
            new Link(nodeArray_1[0], nodeArray_1[1], 10), // 0,1
            new Link(nodeArray_1[0], nodeArray_1[2], 8),  // 0,2
            new Link(nodeArray_1[1], nodeArray_1[3], 4),  // 1,3
            new Link(nodeArray_1[2], nodeArray_1[1], 8),  // 2,1
            new Link(nodeArray_1[2], nodeArray_1[4], 5),  // 2,4
            new Link(nodeArray_1[3], nodeArray_1[5], 5),  // 3,5
            new Link(nodeArray_1[4], nodeArray_1[3], 5),  // 4,3
            new Link(nodeArray_1[4], nodeArray_1[5], 7),  // 4,5
            new Link(nodeArray_1[5], nodeArray_1[6], 12), // 5,6
            new Link(nodeArray_1[5], nodeArray_1[7], 4),  // 5,7
            new Link(nodeArray_1[6], nodeArray_1[2], 7),  // 6,2
            new Link(nodeArray_1[6], nodeArray_1[4], 2),  // 6,4
            new Link(nodeArray_1[6], nodeArray_1[7], 5),  // 6,7
    };

    private static final Node[] nodeArray_2 = {
            new Node(250,50),   // 0
            new Node(50, 150),  // 1
            new Node(250,250),  // 2
            new Node(100,400),  // 3
            new Node(400, 400), // 4
            new Node(450, 150)  // 5
    };
    private static final Link[] EdgeArray_2 = {
            new Link(nodeArray_2[0], nodeArray_2[1], 7),  // 0,1
            new Link(nodeArray_2[0], nodeArray_2[2], 9),  // 0,2
            new Link(nodeArray_2[0], nodeArray_2[5], 14), // 0,5
            new Link(nodeArray_2[1], nodeArray_2[2], 10), // 1,2
            new Link(nodeArray_2[1], nodeArray_2[3], 15), // 1,3
            new Link(nodeArray_2[2], nodeArray_2[3], 11), // 2,3
            new Link(nodeArray_2[2], nodeArray_2[5], 2),  // 2,5
            new Link(nodeArray_2[4], nodeArray_2[3], 6),  // 4,3
            new Link(nodeArray_2[5], nodeArray_2[4], 9)   // 5,4
    };

    private static final Node[] nodeArray_3 = {
            new Node(200,50), // 0
            new Node(100,200), // 1
            new Node(300,200), // 2
            new Node(100,400), // 3
            new Node(300, 400) // 4
    };
    private static final Link[] linkArray_3 = {
            new Link(nodeArray_3[0], nodeArray_3[1], 2),   // 0,1
            new Link(nodeArray_3[0], nodeArray_3[2], 1),   // 0,2
            new Link(nodeArray_3[0], nodeArray_3[4], 14),  // 0,4
            new Link(nodeArray_3[1], nodeArray_3[2], 3),   // 1,2
            new Link(nodeArray_3[1], nodeArray_3[3], 20),  // 1,3
            new Link(nodeArray_3[1], nodeArray_3[4], 13),  // 1,4
            new Link(nodeArray_3[2], nodeArray_3[4], 8),   // 2,4
            new Link(nodeArray_3[4], nodeArray_3[3], 2)    // 4,3
    };

    public static final Graph ONE = new Graph(new Vector<>(Arrays.asList(nodeArray_1)), new Vector<>(Arrays.asList(EdgeArray_1)));
    public static final Graph TWO = new Graph(new Vector<>(Arrays.asList(nodeArray_2)), new Vector<>(Arrays.asList(EdgeArray_2)));
    public static final Graph THREE = new Graph( new Vector<>(Arrays.asList(nodeArray_3)), new Vector<>(Arrays.asList(linkArray_3)));

}
