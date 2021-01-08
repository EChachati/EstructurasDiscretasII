package gui.dijkstra;

import graph.*;
import graph.Canvas;
import gui.ChooseGraph;
import gui.MainFrame;
import gui.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DijkstraGUI extends JPanel {
   // private final Data data = new Data();

    private Node start;
    private Node objective;
    private Node actual;
    private final Graph graph;
    private final Vector<Node> unvisited;
    private final Map<Integer, Integer[]> cost = new HashMap<>(); // NodeID ->  0 ShortestPathFromStart, 1 PreviousVertexID


    public DijkstraGUI(Canvas canvas, MainFrame frame) {
        // Setting Base Config
        this.setLayout(null);
        this.setSize(1024, 720);

        // Creating Buttons
        JButton chooseStartButton = new JButton("Elige Nodo Inicial");
        JButton chooseObjectiveButton = new JButton("Elige Nodo Objetivo");
        JButton switchGraphButton = new JButton("Cambiar Grafo");
        JButton resetGraphButton = new JButton("Reiniciar Grafo");
        JButton nextIterationButton = new JButton("Siguente Iteracion");
        JButton menuButton = new JButton("Menu");

        // Creating Components
        Title title = new Title("ALGORIMO DE DIJKSTRA");
        gui.dijkstra.Legend legend = new gui.dijkstra.Legend();
        Data data = new Data();
        //Adding All Elements
        this.add(canvas);
        this.add(chooseStartButton);
        this.add(chooseObjectiveButton);
        this.add(switchGraphButton);
        this.add(resetGraphButton);
        this.add(nextIterationButton);
        this.add(menuButton);
        this.add(title);
        this.add(legend);
        this.add(data);


        // Setting Buttons Location and Size
        chooseStartButton.setBounds(720, 70, 290, 60);
        chooseObjectiveButton.setBounds(720, 140, 290, 60);
        switchGraphButton.setBounds(720, 545, 290, 60);
        resetGraphButton.setBounds(870, 615, 143, 55);
        nextIterationButton.setBounds(720, 475, 290, 60);
        menuButton.setBounds(720, 615, 142, 55);

        // Setting Atributes From Graph
        this.graph = canvas.getGraph();
        unvisited = new Vector<>(graph.getNodeList());
        for (Node node : graph.getNodeList()) {
            cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
        }

        // Setting Buttons Events
        chooseStartButton.addActionListener(mousePressed -> {
            /*
             * Click a node, then click this button to save it as the start of the algorithm
             */
            if (start != null) {
                start.setColor(Color.GRAY);
            }
            start = canvas.getSelectedNode();
            actual = start;
            if (start != null) {
                for (Node node : graph.getNodeList()) {
                    cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
                }
                cost.put(start.getIdentifier(), new Integer[]{0, -1});
                data.setStart(String.valueOf(start.getIdentifier()));
                start.setColor(Color.PINK);
            }
            canvas.repaint();
        });

        chooseObjectiveButton.addActionListener(mousePressed -> {
            /*
             * Click a node, then click this button to save it as the objective of the algorithm
             */
            if (objective != null) {
                objective.setColor(Color.GRAY);
            }
            objective = canvas.getSelectedNode();
            if (objective != null) {
                data.setObjective(String.valueOf(objective.getIdentifier()));
                objective.setColor(Color.GREEN);
            }
            canvas.repaint();
        });

        nextIterationButton.addActionListener(mousePressed -> {
            /*
            * Shows the next iteration for the Dijkstra Algorithm every click
            */
            if (unvisited.contains(objective)) { // If the Objective hasn't been checked
                if (unvisited.contains(actual)) { // If there's a new Actual Node
                    // Check all Nodes which can be reached by the actual node
                    for (Node n : actual.getAllAccessNodes()) {
                        // Calculate the distance between the start and checking node
                        int visitedId = n.getIdentifier();
                        Link linkActualToN = (Link) actual.undirectedMap.get(n.getIdentifier())[1];
                        int shortestPathFromStart = cost.get(actual.getIdentifier())[0] + linkActualToN.getDistance();

                        // If shorter or not checked before set new distance cost
                        if (cost.get(n.getIdentifier())[0] > shortestPathFromStart || cost.get(n.getIdentifier())[1] == -1) {
                            cost.put(visitedId, new Integer[]{shortestPathFromStart, actual.getIdentifier()});
                        }
                    }
                    unvisited.removeElement(actual);
                    actual.setColor(Color.YELLOW);
                } else { // If need to find a new actual node
                    // Check for the Unvisited node with the shortest distance
                    int lowerDistance = Integer.MAX_VALUE;
                    for (Node k : unvisited) {
                        if (cost.get(k.getIdentifier())[0] < lowerDistance) {
                            actual = k;
                            lowerDistance = cost.get(k.getIdentifier())[0];
                        }
                    }
                    actual.setColor(Color.PINK);
                }
            } else { // If Objective has been found
                // Prepare the Output
                StringBuilder path = new StringBuilder("" + objective.getIdentifier());
                graph.getNodeList().get(start.getIdentifier()).setColor(Color.GREEN);

                int objectiveInt = objective.getIdentifier();
                while (objectiveInt != start.getIdentifier()) {
                    graph.getNodeList().get(objectiveInt).setColor(Color.GREEN);
                    objectiveInt = cost.get(objectiveInt)[1];
                    path.insert(0, objectiveInt + " => ");
                    System.out.println(path.toString());
                }
                data.setOptimalPath(path.toString());
            }
            canvas.repaint();
        });

        resetGraphButton.addActionListener(mousePressed -> {
            /*
             * Set the Graph Canvas to his initial state
             */
            canvas.reset();
            start = canvas.getSelectedNode();
            data.setStart("");
            data.setObjective("");
            data.setOptimalPath("  C a m i n o   O p t i m o");
            canvas.repaint();
        });

        switchGraphButton.addActionListener(actionEvent -> {
            /*
             * Go Back to Choose Algorithm Menu
             */
            frame.setContentPane(new ChooseGraph(ChooseGraph.DIJKSTRA_ALGORITHM, frame));
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