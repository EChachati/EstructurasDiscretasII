package graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import algorithms.Dijkstra;
import algorithms.Kruskal;
import algorithms.Warshall;

public class Canvas extends JPanel implements MouseListener {

    private final Graph graph;
    Node node1, node2 = null;

    public Canvas(Graph graph) {
        this.graph = graph;
    }

    public Canvas() {
        this.graph = new Graph();
        this.addMouseListener(this);
    }

    // Override JComponent.paint()
    public void paint(Graphics g){
        for(Node node: graph.getNodeList()){ node.paint(g); }
        for(Link link : graph.getLinkList()){ link.paint(g); }
    }

    public Graph getGraph() { return graph; }

    @Override
    /*
     * Adding a new Node to the List of Nodes when LeftMouse Clicked
     * */
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            if (graph.getNodeList().isEmpty()) {
                graph.getNodeList().add(new Node(mouseEvent.getX(), mouseEvent.getY()));
                repaint();
            } else {
                boolean emptySpace = true;
                for (Node node : graph.getNodeList()) {
                    if (node.getOval().contains(mouseEvent.getPoint())) {
                        emptySpace = false;
                    }
                }
                if (emptySpace) {
                    graph.getNodeList().add(new Node(mouseEvent.getX(), mouseEvent.getY()));
                    repaint();
                }
            }
        }
        if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
            for (Node node : graph.getNodeList()) {
                if (node.getOval().contains(mouseEvent.getPoint())) {
                    if (node1 == null) {
                        node1 = node;
                    } else if (!node1.getOval().contains(mouseEvent.getPoint())) {
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
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void reset(){
        for(Node node : graph.getNodeList()){
            node.setColor(Color.GRAY);
        }
        for(Link link: graph.getLinkList()){
            link.setColor(Color.BLACK);
        }
        try {
            Thread.sleep(1000);
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

        if (n == 1) {
            canvas = new Canvas(PREDEFINED_GRAPH.graphNumber1());
        } else if (n == 2) {
            canvas = new Canvas(PREDEFINED_GRAPH.graphNumber2());
        } else if (n == 3) {
            canvas = new Canvas(PREDEFINED_GRAPH.graphNumber3());
        } else {
            canvas = new Canvas();
        }


        JFrame window = new JFrame("Graphs");
        window.add(canvas);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        //System.out.println(Dijkstra.shortestPathDijkstra(canvas, 1, 4));
        //canvas.reset();
        //System.out.println(Kruskal.minimumSpanningTree(canvas));
        Warshall.warshallAlgorithm(canvas.graph);
    }
}