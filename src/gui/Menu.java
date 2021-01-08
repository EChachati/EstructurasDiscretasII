package gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    JButton dijkstra = new JButton("ALGORITMO DE DIJKSTRA");
    JButton kruskal =  new JButton("ALGORITMO DE KRUSKAL");
    JButton warshall = new JButton("ALGORITMO DE WARSHALL");
    MainFrame frame;

    public Menu(MainFrame frame){
        this.frame=frame;
        setSize(1024,720);
        setLayout(null);

        add(dijkstra);
        add(kruskal);
        add(warshall);
        dijkstra.setBounds(256,160, 512,144);
        kruskal.setBounds(256,305, 512,144);
        warshall.setBounds(256,450, 512,144);

        dijkstra.addActionListener(x -> {
            setVisible(false);
            frame.setContentPane(new ChooseGraph(ChooseGraph.DIJKSTRA_ALGORITHM, frame));
            frame.invalidate();
            frame.validate();
        });

        kruskal.addActionListener( x -> {
            setVisible(false);
            frame.setContentPane(new ChooseGraph(ChooseGraph.KRUSKAL_ALGORITHM, frame));

            frame.invalidate();
            frame.validate();
        });

        warshall.addActionListener( x -> {
            setVisible(false);
            frame.setContentPane(new ChooseGraph(ChooseGraph.WARSHALL_ALGORITHM, frame));
            frame.invalidate();
            frame.validate();
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 50));
        g.drawString("Elige un Algoritmo",285,95);
    }
}
