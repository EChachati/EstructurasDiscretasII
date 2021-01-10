package gui.warshall;

import algorithms.Warshall;
import graph.Graph;
import gui.MainFrame;
import gui.dijkstra.Title;

import javax.swing.*;
import java.util.Vector;

public class WarshallGUI extends JPanel {
    private Graph graph;
    private Vector<Vector<Vector<Integer>>> allTransitiveMatrix;
    private int actual = 2;

    public WarshallGUI(Graph graph, MainFrame frame){
        this.graph = graph;
        this.allTransitiveMatrix = Warshall.warshallAlgorithm(graph);

        // Setting Base Config
        setLayout(null);
        setSize(1024,720);

        // Creating Buttons
        JButton backIterationButton = new JButton("Iteracion Anterior");
        JButton switchGraphButton = new JButton("Cambiar Grafo");
        JButton resetGraphButton = new JButton("Reiniciar Grafo");
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
        gui.warshall.Data data = new Data();

        //Adding All Elements
        this.add(new SmallCanvas(graph));
        this.add(backIterationButton);
        this.add(switchGraphButton);
       // this.add(resetGraphButton);
        this.add(nextIterationButton);
        this.add(menuButton);
        this.add(title);
        this.add(matrix);
        this.add(data);

        // Setting Buttons Location and Size
        backIterationButton.setBounds(720, 405, 290, 60);
        nextIterationButton.setBounds(720, 475, 290, 60);
       // resetGraphButton.setBounds   (720, 475, 290, 60);
        switchGraphButton.setBounds  (720, 545, 290, 60);
        menuButton.setBounds         (720, 615, 290, 60);

    }

}
