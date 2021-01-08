package gui;

import graph.Canvas;
import graph.Predefined;

import javax.swing.*;

public class MainFrame extends JFrame {
/*
    Menu menu = new Menu(this);
    ChooseGraph[] chooseGraph = {
            new ChooseGraph(ChooseGraph.DIJKSTRA_ALGORITHM, this),
            new ChooseGraph(ChooseGraph.KRUSKAL_ALGORITHM, this),
            new ChooseGraph(ChooseGraph.WARSHALL_ALGORITHM, this)
    };
    DijkstraGUI[] dijkstraGui = {
            new DijkstraGUI(new Canvas(Predefined.graphNumber1()), this),
            new DijkstraGUI(new Canvas(Predefined.graphNumber2()), this),
            new DijkstraGUI(new Canvas(Predefined.graphNumber3()), this)
    };
*/


    public MainFrame(){
        setSize(1024,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(new Menu(this));
        invalidate();
        validate();

    }
}
