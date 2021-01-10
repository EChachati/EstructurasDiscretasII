package gui.warshall;

import javax.swing.*;
import java.awt.*;

public class Data extends JPanel {
    String actualTable = "Tabla: ";

    public Data(int tableIndex) {
        this.setLayout(null);
        this.setBounds(720, 345, 290, 55);
        this.setActualTable(tableIndex);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0,0,289,55);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 289, 54);
        g.drawString(this.actualTable, 5, 38 );
    }
    public void setActualTable(int tableIndex){
        if (tableIndex == -1) {
            actualTable = "Tabla: ";
        } else if (tableIndex == 0 ){
            actualTable = "Tabla: Transitiva";
        } else {
            actualTable = "Tabla: " + (tableIndex - 1);
        }
    }
}