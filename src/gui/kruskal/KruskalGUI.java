package gui.kruskal;

import graph.Canvas;
import graph.Graph;
import graph.Link;
import gui.ChooseGraph;
import gui.MainFrame;
import gui.Menu;
import gui.dijkstra.Title;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static algorithms.Kruskal.isCycle;
import static algorithms.Kruskal.sortLinksByDistance;

public class KruskalGUI extends JPanel {
    private final Graph graph;
    private final Vector<Link> unusedLinks;
    private final Vector<Link> usedLinks = new Vector<>();
    private final Vector<Link> allLinks ;
    private int cost = 0;
    private Link actual;

    public KruskalGUI(Canvas canvas, MainFrame frame){

        graph = canvas.getGraph();
        unusedLinks = new Vector<>(sortLinksByDistance(graph.getLinkList()));
        allLinks = new Vector<>(sortLinksByDistance(graph.getLinkList()));

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
        Title title = new Title("ALGORITMO DE KRUSKAL");
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

        // Setting buttons functionalities
        nextIterationButton.addActionListener( mousePressed -> {
            if(usedLinks.size() != graph.getNodeList().size()-1 || actual.getColor() == Color.YELLOW){

                if(unusedLinks.contains(actual)){ // If there's a new Actual Link
                    // Check if the ActualLink generates a cycle
                    unusedLinks.remove(actual);
                    if(isCycle(usedLinks)){ // UNACCEPTABLE, Generates Cycle
                        actual.setColor(Color.RED);
                        usedLinks.remove(actual);
                    } else { // ACCEPTABLE, Does not generate Cycle
                        actual.setColor(Color.GREEN.darker().darker());
                        cost += actual.getDistance();
                        data.setActualCost(cost);
                    }
                } else { // If need to find a new actual Link
                    actual = unusedLinks.firstElement();
                    usedLinks.add(actual);
                    actual.setColor(Color.yellow);
                    data.setActualLink(actual);
                }
            }
            canvas.repaint();
        });


            backIterationButton.addActionListener(mousePressed -> {
                try {
                if (actual.getColor() == Color.RED) {
                    actual.setColor(Color.YELLOW);
                    usedLinks.add(actual);
                    unusedLinks.add(0, actual);

                } else if (actual.getColor() == Color.YELLOW) {
                    actual.setColor(Color.BLACK);
                    usedLinks.remove(actual);
                    if (allLinks.indexOf(actual) == 0) {
                        canvas.reset();
                        frame.setContentPane(new KruskalGUI(canvas, frame));
                        frame.invalidate();
                        frame.validate();

                    } else {
                        actual = allLinks.get(allLinks.indexOf(actual) - 1);
                    }

                } else { // green fuck u
                    actual.setColor(Color.YELLOW);
                    cost -= actual.getDistance();
                    data.setActualCost(cost);
                    unusedLinks.add(0, actual);
                }
                } catch (NullPointerException a) {
                    System.out.println("No puedes volver mas");
                }
                canvas.repaint();
            });


        resetGraphButton.addActionListener(mousePressed -> {
            /*
             * Set the Graph Canvas to his initial state
             */
            canvas.reset();
            frame.setContentPane(new KruskalGUI(canvas, frame));
            frame.invalidate();
            frame.validate();
        });

        switchGraphButton.addActionListener(actionEvent -> {
            /*
             * Go Back to Choose Algorithm Menu
             */
            frame.setContentPane(new ChooseGraph(ChooseGraph.KRUSKAL_ALGORITHM, frame));
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