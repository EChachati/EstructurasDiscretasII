package gui.dijkstra;

import javax.swing.*;
import java.awt.*;

public class Legend extends JPanel {
    public Legend() {
        this.setLayout(null);
        this.setBounds(720, 210, 290, 136);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D gGray = (Graphics2D) g;
        Graphics2D gGreen = (Graphics2D) g;
        Graphics2D gYellow = (Graphics2D) g;
        Graphics2D gPink = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, 289, 135);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 289, 135);
        gGray.setColor(Color.GRAY);
        gGray.fillRect(1, 1, 32, 33);
        gGreen.setColor(Color.GREEN);
        gGreen.fillRect(1, 35, 32, 33);
        gYellow.setColor(Color.YELLOW);
        gYellow.fillRect(1, 69, 32, 33);
        gPink.setColor(Color.PINK);
        gPink.fillRect(1, 103, 32, 32);

        g.setColor(Color.BLACK);
        g.drawLine(0, 34, 289, 34);
        g.drawLine(0, 68, 289, 68);
        g.drawLine(0, 102, 289, 102);
        g.drawLine(32, 0, 32, 135);
        g.setFont(new Font("Fira Code SemiBold", Font.PLAIN, 18));
        g.drawString("NO REVISADAS", 95, 25);
        g.drawString("OBJETIVO / RUTA OPTIMA", 45, 60);
        g.drawString("REVISADOS", 110, 90);
        g.drawString("NODO ACTUAL", 95, 125);
    }
}