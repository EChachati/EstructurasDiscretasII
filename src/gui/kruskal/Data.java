package gui.kruskal;

import graph.Link;

import javax.swing.*;
import java.awt.*;

public class Data extends JPanel {
    String actualLink = "Link Actual: ";
    String cost = "Costo: ";

    public Data() {
        this.setLayout(null);
        this.setBounds(720, 285, 290, 111);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0,0,289,110);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 289, 110);
        g.drawLine(0,55,289,55);
        g.drawString(this.actualLink, 5, 38 );
        g.drawString(this.cost, 5, 88 );
    }
    public void setActualLink(Link link){
        this.actualLink = "Link Actual: (" + link.node.get(0).getIdentifier() + ", " + link.node.get(1).getIdentifier() + ").";
        repaint();
    }
    public void setActualCost(int cost){
        this.cost = String.format("Costo: %d", cost);
        repaint();
    }
}