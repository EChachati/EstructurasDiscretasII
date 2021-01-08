package gui;

import graph.Canvas;
import graph.Predefined;
import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

import javax.swing.*;
import java.awt.*;

public class ChooseGraph extends JPanel {
    private final MainFrame frame;
    private final JButton graph_1 = new JButton("GRAFO PREDETERMINADO 1");
    private final JButton graph_2 = new JButton("GRAFO PREDETERMINADO 2");
    private final JButton graph_3 = new JButton("GRAFO PREDETERMINADO 3");
    Canvas canvas;
    public final static int DIJKSTRA_ALGORITHM = 0;
    public final static int KRUSKAL_ALGORITHM = 1;
    public final static int WARSHALL_ALGORITHM = 2;

    public ChooseGraph(int selectedAlgorithm, MainFrame frame){
        this.frame = frame;
        setSize(1024,720);
        setLayout(null);
        add(graph_1);
        add(graph_2);
        add(graph_3);

        graph_1.setBounds(256,160, 512,144);
        graph_2.setBounds(256,305, 512,144);
        graph_3.setBounds(256,450, 512,144);

        graph_1.addActionListener(action -> {
            if(selectedAlgorithm == (ChooseGraph.DIJKSTRA_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new DijkstraGUI(new Canvas(Predefined.graphNumber1()), frame));
                frame.invalidate();
                frame.validate();
            }
        });

        graph_2.addActionListener(action -> {
            if(selectedAlgorithm == (ChooseGraph.DIJKSTRA_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new DijkstraGUI(new Canvas(Predefined.graphNumber2()), frame));
                frame.invalidate();
                frame.validate();
            }

        });

        graph_3.addActionListener(action -> {
            if(selectedAlgorithm == (ChooseGraph.DIJKSTRA_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new DijkstraGUI(new Canvas(Predefined.graphNumber3()), frame));
                frame.invalidate();
                frame.validate();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 50));
        g.drawString("Elige un Grafo",285,95);
    }

    public Canvas getSelectedGraph() { return canvas; }
    public MainFrame gerFrame(){ return frame; }

}
