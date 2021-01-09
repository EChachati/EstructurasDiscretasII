package gui.dijkstra;

import javax.swing.*;
import java.awt.*;

public class Title extends JPanel {
    String title;

    public Title(String title) {
        this.title = title;
        this.setLayout(null);
        this.setBounds(720, 10, 290, 40);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
        g.drawString(this.title, 2, 30);
    }

}