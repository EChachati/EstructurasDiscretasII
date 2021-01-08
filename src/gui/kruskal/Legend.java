package gui.kruskal;

import javax.swing.*;
import java.awt.*;

public class Legend extends JPanel {
    public Legend() {
        this.setLayout(null);
        this.setBounds(720, 60, 290, 136);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D gBlack = (Graphics2D) g;
        Graphics2D gGreen = (Graphics2D) g;
        Graphics2D gYellow = (Graphics2D) g;
        Graphics2D gRed = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, 289, 135);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 289, 135);
        gBlack.setColor(Color.BLACK);
        gBlack.fillRect(1, 1, 32, 33);
        gGreen.setColor(Color.GREEN.darker());
        gGreen.fillRect(1, 35, 32, 33);
        gYellow.setColor(Color.YELLOW);
        gYellow.fillRect(1, 69, 32, 33);
        gRed.setColor(Color.RED.darker());
        gRed.fillRect(1, 103, 32, 32);

        g.setColor(Color.BLACK);
        g.drawLine(0, 34, 289, 34);
        g.drawLine(0, 68, 289, 68);
        g.drawLine(0, 102, 289, 102);
        g.drawLine(32, 0, 32, 135);
        g.setFont(new Font("Fira Code SemiBold", Font.PLAIN, 18));
        g.drawString("NO REVISADAS", 95, 25);
        g.drawString("ACEPTADO", 115, 60);
        g.drawString("REVISION ACTUAL", 85, 92);
        g.drawString("NO ACEPTADO", 95, 125);
    }
}
