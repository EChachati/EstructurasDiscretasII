package gui.warshall;

import algorithms.Warshall;
import graph.Graph;
import gui.ChooseGraph;
import gui.MainFrame;
import gui.Menu;
import gui.dijkstra.Title;

import javax.swing.*;
import java.util.Vector;

public class WarshallGUI extends JPanel {
    private final Vector<Vector<Vector<Integer>>> allTransitiveMatrix;

    public WarshallGUI(Graph graph, MainFrame frame, int actual){
        this.allTransitiveMatrix = Warshall.warshallAlgorithm(graph);

        // Setting Base Config
        setLayout(null);
        setSize(1024,720);

        // Creating Buttons
        JButton backIterationButton = new JButton("Iteracion Anterior");
        JButton switchGraphButton = new JButton("Cambiar Grafo");
        JButton nextIterationButton = new JButton("Iteracion Siguente");
        JButton menuButton = new JButton("Menu");

        //Creating Components
        Title title = new Title("Algoritmo de Warshall");
        Matrix matrix = new Matrix(allTransitiveMatrix.get(0));
        if (actual == -1){
            matrix = matrix.getEmptyMatrix();
        } else {
            matrix = new Matrix(allTransitiveMatrix.get(actual));
        }
        gui.warshall.Data data = new Data(actual);

        //Adding All Elements
        this.add(new SmallCanvas(graph));
        this.add(backIterationButton);
        this.add(switchGraphButton);
        this.add(nextIterationButton);
        this.add(menuButton);
        this.add(title);
        this.add(matrix);
        this.add(data);

        // Setting Buttons Location and Size
        matrix.setBounds(10,10,700,660);
        backIterationButton.setBounds(720, 405, 290, 60);
        nextIterationButton.setBounds(720, 475, 290, 60);
        switchGraphButton.setBounds  (720, 545, 290, 60);
        menuButton.setBounds         (720, 615, 290, 60);

        // Setting Buttons Functionalities
        nextIterationButton.addActionListener(x -> {
            if (actual != allTransitiveMatrix.size()-1){
                frame.setContentPane(new WarshallGUI(graph, frame, actual+1));
                frame.invalidate();
                frame.validate();
            }
        });

        backIterationButton.addActionListener(x -> {
            if (actual != -1){
                frame.setContentPane(new WarshallGUI(graph, frame, actual-1));
                frame.invalidate();
                frame.validate();
            }
        });

        switchGraphButton.addActionListener(actionEvent -> {
            /*
             * Go Back to Choose Algorithm Menu
             */
            frame.setContentPane(new ChooseGraph(ChooseGraph.WARSHALL_ALGORITHM , frame));
            frame.invalidate();
            frame.validate();
        });

        menuButton.addActionListener(x -> {
            /*
             * Go Back to Main Menu
             */
            frame.setContentPane(new Menu(frame));
            frame.invalidate();
            frame.validate();
        });
    }

}
