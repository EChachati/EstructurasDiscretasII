package gui.kruskal;

import graph.Canvas;
import graph.Predefined;
import gui.MainFrame;
import gui.dijkstra.Data;
import gui.dijkstra.Legend;
import gui.dijkstra.Title;

import javax.swing.*;
import java.awt.*;

public class KruskalGUI extends JPanel {

    public KruskalGUI(Canvas canvas, MainFrame frame){
        // Setting Base Config
        this.setLayout(null);
        this.setSize(1024, 720);

        // Creating Buttons
        JButton backIterationButton = new JButton("Iteracion Anterior");
        JButton switchGraphButton = new JButton("Cambiar Grafo");
        JButton resetGraphButton = new JButton("Reiniciar Grafo");
        JButton nextIterationButton = new JButton("Iteracion Siguente");
        JButton menuButton = new JButton("Menu");

        // Creating Components
        Title title = new Title("ALGORIMO DE KRUSKAL");
        gui.kruskal.Legend legend = new gui.kruskal.Legend();
        gui.kruskal.Data data = new gui.kruskal.Data();
        data.setBounds(720, 210, 290, 111);

        //Adding All Elements
        this.add(canvas);
        this.add(backIterationButton);
        this.add(switchGraphButton);
        this.add(resetGraphButton);
        this.add(nextIterationButton);
        this.add(menuButton);
        this.add(title);
        this.add(legend);
        this.add(data);


        // Setting Buttons Location and Size
        backIterationButton.setBounds(720, 335, 290, 60);
        nextIterationButton.setBounds(720, 405, 290, 60);
        resetGraphButton.setBounds   (720, 475, 290, 60);
        switchGraphButton.setBounds  (720, 545, 290, 60);
        menuButton.setBounds         (720, 615, 290, 60);
    }

    public static void main(String[] args) {
        MainFrame w = new MainFrame();
        JFrame window = new JFrame();
        window.add(new KruskalGUI(new Canvas(Predefined.graphNumber1()), w));
        window.setSize(1028, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
}

