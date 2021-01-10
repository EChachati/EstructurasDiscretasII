package gui.warshall;

import graph.Graph;
import graph.Link;
import graph.Node;

import javax.swing.*;
import java.awt.*;

public class SmallCanvas extends JPanel {
    private final Graph graph;
    public SmallCanvas(Graph graph) {
        Node.setProportion(0.42);
        this.setLayout(null);
        this.setBounds(720,50,290,290);
        this.graph = graph;
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Node.setFont(new Font("",Font.BOLD,13));
        Node.setDiameter(16);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0,0,699,659);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,289,289);

        for(Node node: graph.getNodeList()){
            node.recalculate();
        }
        for(Link link : graph.getLinkList()){
            link.recalculate();
            link.paint(g); }
        for(Node node: graph.getNodeList()){
            node.paint(g);
        }
    }
}
