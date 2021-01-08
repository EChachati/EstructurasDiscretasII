package graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Canvas extends JPanel implements MouseListener {

    private final Graph graph;
    Node node1, node2 = null;
    boolean usePredefined = false;
    Node selectedNode = null;

    public Canvas(Graph graph) {
        this.setLayout(null);
        this.setBounds(10,10,700,700);
        this.graph = graph;
        this.usePredefined = true;
        this.addMouseListener(this);
    }

    public Canvas() {
        this.setLayout(null);
        this.setBounds(0,0,700,700);
        this.graph = new Graph();
        this.addMouseListener(this);
    }

    // Override JComponent.paint()
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0,0,699,659);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,699,660);
        for(Node node: graph.getNodeList()){ node.paint(g); }
        for(Link link : graph.getLinkList()){ link.paint(g); }
    }

    public Graph getGraph() { return graph; }
    public Node getSelectedNode(){ return selectedNode; }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!usePredefined) {
            /*
             * Adding a new Node to the List of Nodes when LeftMouse Clicked
             * */
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
            /*
             * Adding a new Link when RightMouse clicked in two different nodes
             * */
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
        } else {
            if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                for (Node node : this.getGraph().getNodeList()) {
                    if (node.getColor() == Color.BLUE){
                        node.setColor(Color.GRAY);
                    }
                    if (node.getOval().contains(mouseEvent.getPoint())) {
                        this.selectedNode = node;
                        this.selectedNode.setColor(Color.BLUE);
                        repaint();
                    }
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) { }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) { }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }

    @Override
    public void mouseExited(MouseEvent mouseEvent) { }

    public void reset(){
        for(Node node : graph.getNodeList()){
            node.setColor(Color.GRAY);
        }
        for(Link link: graph.getLinkList()){
            link.setColor(Color.BLACK);
        }
        selectedNode = graph.getNodeList().get(0);
    }

    public static void main(String[] args) {
        Canvas canvas;
        int n = Integer.parseInt(JOptionPane.showInputDialog("Choose one:" +
                "\n 0 -> Draw Graph" +
                "\n 1 -> Predefined Graph 1" +
                "\n 2 -> Predefined Graph 2" +
                "\n 3 -> Predefined Graph 3"));

        if (n == 1) {
            canvas = new Canvas(Predefined.graphNumber1());
        } else if (n == 2) {
            canvas = new Canvas(Predefined.graphNumber2());
        } else if (n == 3) {
            canvas = new Canvas(Predefined.graphNumber3());
        } else {
            canvas = new Canvas();
        }

        JFrame window = new JFrame();
        window.add(canvas);
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}