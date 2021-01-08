package gui.dijkstra;

import javax.swing.*;
import java.awt.*;

public class Data extends JPanel {
    String start = "";
    String objective = "";
    String optimal = "  C a m i n o   O p t i m o";

    public Data() {
        this.setLayout(null);
        this.setBounds(720, 355, 290, 111);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0,0,289,110);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 289, 110);
        g.drawLine(0,37,289,37);
        g.drawLine(0,74,289,74);
        g.drawString("Nodo Inicial: ", 5, 30 );
        g.drawString(this.start, 180, 30 );
        g.drawString("Nodo Objetivo: ", 5, 60 );
        g.drawString(this.objective, 180, 60 );
        g.drawString(this.optimal, 5, 100 );
    }
    public void setStart(String start){
        this.start = start;
        repaint();
    }
    public void setObjective(String objective){
        this.objective = objective;
        repaint();
    }
    public void setOptimalPath(String path){
        this.optimal = path;
        repaint();
    }
}