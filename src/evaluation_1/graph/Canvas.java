package evaluation_1.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Canvas extends JPanel implements MouseListener {

    private final Graph graph;
    Node node1, node2 = null;

    public Canvas(Graph graph){ this.graph = graph; }

    public Canvas(){
        this.graph = new Graph();
        this.addMouseListener(this);
    }

    // Override JComponent.paint()
    public void paint(Graphics g){
        for(Node node: graph.getNodeList()){ node.paint(g); }
        for(Link link: graph.getLinkList()){ link.paint(g); }
    }

    @Override
    /*
     * Adding a new Node to the List of Nodes when LeftMouse Clicked
     * */
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1){
            if (graph.getNodeList().isEmpty()) {
                graph.getNodeList().add(new Node(mouseEvent.getX(), mouseEvent.getY()));
                repaint();
            } else {
                boolean emptySpace = true;
                for(Node node : graph.getNodeList()){
                    if(node.getOval().contains(mouseEvent.getPoint())){
                        emptySpace = false;
                    }
                }
                if(emptySpace) {
                    graph.getNodeList().add(new Node(mouseEvent.getX(), mouseEvent.getY()));
                    repaint();
                }
            }
        }
        if (mouseEvent.getButton() == MouseEvent.BUTTON3){
            for(Node node: graph.getNodeList()){
                if(node.getOval().contains(mouseEvent.getPoint())){
                    if(node1 == null){
                        node1 = node;
                    } else if (!node1.getOval().contains(mouseEvent.getPoint())){
                        node2 = node;
                        graph.getLinkList().add(new Link(node1, node2));
                        repaint();
                        node1 = null;
                        node2 = null;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    public String shortestPathDijkstra(int start, int objective) {
        Node actual = graph.getNodeList().get(start);
        graph.getNodeList().get(objective).setColor(Color.green);
        Vector<Node> unvisited = new Vector<>(graph.getNodeList());
        Map<Integer, Integer[]> cost = new HashMap<>(); // NodeID ->  0 ShortestPathFromStart, 1 PreviousVertexID

        for (Node node : graph.getNodeList()) {
            cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
        }

        cost.put(start, new Integer[]{0, -1});

        while (unvisited.contains(graph.getNodeList().get(objective)) ) {
            //Actual = Pink   ***   Objective & Final Path = green  ***  Visited = Yellow
            actual.setColor(Color.PINK);
            waitFor();
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
            for(Node k: unvisited){
                if (cost.get(k.getIdentifier())[0] < lowerDistance){
                    actual = k;
                    lowerDistance = cost.get(k.getIdentifier())[0];
                }
            }

            unvisited.removeElement(actual);
            actual.setColor(Color.PINK);
            waitFor();
        }
        StringBuilder str = new StringBuilder("" + objective);
        graph.getNodeList().get(start).setColor(Color.GREEN);
        while(objective != start){
            graph.getNodeList().get(objective).setColor(Color.GREEN);
            objective = cost.get(objective)[1];
            str.insert(0, objective + " -> ");
        }
        waitFor();
        return str.toString();
    }

    private void waitFor(){
        try {
            Thread.sleep(800);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Canvas canvas;
        int n = Integer.parseInt(JOptionPane.showInputDialog("Choose one:" +
                "\n 0 -> Draw Graph" +
                "\n 1 -> Predefined Graph 1" +
                "\n 2 -> Predefined Graph 2" +
                "\n 3 -> Predefined Graph 3"));
        if (n == 3) {
            canvas = new Canvas(PREDEFINED_GRAPH.THREE);
        } else if (n == 2){
            canvas = new Canvas(PREDEFINED_GRAPH.TWO);
        } else if (n == 1) {
            canvas = new Canvas(PREDEFINED_GRAPH.ONE);
        } else {
            canvas = new Canvas();
        }

        JFrame window = new JFrame("Graphs");
        window.add(canvas);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        System.out.println(canvas.shortestPathDijkstra(5,1));
    }
}