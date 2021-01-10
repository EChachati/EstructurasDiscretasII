package gui;

import graph.Canvas;
import graph.Predefined;
import gui.dijkstra.DijkstraGUI;
import gui.kruskal.KruskalGUI;
import gui.warshall.WarshallGUI;

import javax.swing.*;
import java.awt.*;

public class ChooseGraph extends JPanel {
    public final static int DIJKSTRA_ALGORITHM = 0;
    public final static int KRUSKAL_ALGORITHM = 1;
    public final static int WARSHALL_ALGORITHM = 2;

    public ChooseGraph(int selectedAlgorithm, MainFrame frame){
        setSize(1024,720);
        setLayout(null);

        // Creating Buttons
        JButton graph_1 = new JButton("GRAFO PREDETERMINADO 1");
        JButton graph_2 = new JButton("GRAFO PREDETERMINADO 2");
        JButton graph_3 = new JButton("GRAFO PREDETERMINADO 3");

        // Adding Buttons
        add(graph_1);
        add(graph_2);
        add(graph_3);

        // Setting Button's Size and Location
        graph_1.setBounds(256,160, 512,144);
        graph_2.setBounds(256,305, 512,144);
        graph_3.setBounds(256,450, 512,144);

        /* Adding Events to Buttons
        * Switch to the Selected GUI
        */
        graph_1.addActionListener(action -> {
            if(selectedAlgorithm == (ChooseGraph.DIJKSTRA_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new DijkstraGUI(new Canvas(Predefined.graphNumber1()), frame));
                frame.invalidate();
                frame.validate();
            } else if(selectedAlgorithm == (ChooseGraph.KRUSKAL_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new KruskalGUI(new Canvas(Predefined.graphNumber1()), frame));
                frame.invalidate();
                frame.validate();
            } else if (selectedAlgorithm == ChooseGraph.WARSHALL_ALGORITHM){
                frame.setContentPane(new WarshallGUI(Predefined.graphNumber1(), frame));
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
            } else if(selectedAlgorithm == (ChooseGraph.KRUSKAL_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new KruskalGUI(new Canvas(Predefined.graphNumber2()), frame));
                frame.invalidate();
                frame.validate();
            } else if (selectedAlgorithm == ChooseGraph.WARSHALL_ALGORITHM){
                frame.setContentPane(new WarshallGUI(Predefined.graphNumber2(), frame));
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
            } else if(selectedAlgorithm == (ChooseGraph.KRUSKAL_ALGORITHM)){
                setVisible(false);
                frame.setContentPane(new KruskalGUI(new Canvas(Predefined.graphNumber3()), frame));
                frame.invalidate();
                frame.validate();
            } else if (selectedAlgorithm == ChooseGraph.WARSHALL_ALGORITHM){
                frame.setContentPane(new WarshallGUI(Predefined.graphNumber3(), frame));
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
}
