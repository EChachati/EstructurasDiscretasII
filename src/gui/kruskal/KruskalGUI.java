package gui.kruskal;

import graph.Canvas;
import graph.Graph;
import graph.Link;
import graph.Predefined;
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
    private Graph graph;
    private Vector<Link> unusedLinks;
    private Vector<Link> usedLinks = new Vector<>();
    private Vector<Link> unvalidLinks = new Vector<>();
    private int cost = 0;
    private Link actual;

    public KruskalGUI(Canvas canvas, MainFrame frame){

        graph = canvas.getGraph();
        unusedLinks = new Vector<>(sortLinksByDistance(graph.getLinkList()));


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

        nextIterationButton.addActionListener( mousePressed -> {
            if(!unusedLinks.isEmpty()){

                if(unusedLinks.contains(actual)){ // If there's a new Actual Link
                    // Check if the ActualLink generates a cycle
                    unusedLinks.remove(actual);
                    if(isCycle(usedLinks)){ // UNACCEPTABLE, Generates Cycle
                        actual.setColor(Color.RED);
                        usedLinks.remove(actual);
                        unvalidLinks.add(actual);
                    } else { // ACCEPTABLE, Does not generate Cycle
                        actual.setColor(Color.GREEN.darker());
                        cost += actual.getDistance();
                        data.setActualCost(cost);
                    }
                } else { // If need to find a new actual Link
                    usedLinks.add(unusedLinks.firstElement());
                    actual = usedLinks.lastElement();
                    actual.setColor(Color.yellow);
                    data.setActualLink(actual);
                }
            }
            canvas.repaint();
        });

        /*
        backIterationButton.addActionListener( mousePressed -> {
            if(unusedLinks.contains(actual)){
                // set down actual link
                actual.setColor(Color.BLACK);
            } else {
                // set yellow last checked link usedlinks
                actual = usedLinks.lastElement();
                actual.setColor(Color.YELLOW);
                usedLinks.remove(actual);
                unusedLinks.add(0, actual);
            }
        });
         */

        resetGraphButton.addActionListener(mousePressed -> {
            /*
             * Set the Graph Canvas to his initial state
             */
            canvas.reset();
            frame.setContentPane(new KruskalGUI(canvas, frame));;
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

