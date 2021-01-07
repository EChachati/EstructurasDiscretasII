package gui;

import graph.*;
import graph.Canvas;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DijkstraGUI extends JPanel{
    private final Canvas canvas;
    private final JButton chooseStartButton = new JButton("Elige Nodo Inicial");
    private final JButton chooseObjectiveButton = new JButton("Elige Nodo Objetivo");
    private final JButton switchGraphButton = new JButton("Cambiar Grafo");
    private final JButton resetGraphButton = new JButton("Reiniciar Grafo");
    private final JButton initAlgorithmButton = new JButton("Siguente");
    private final JButton backButton = new JButton("Volver");
    private final Title title = new Title("ALGORIMO DE DIJKSTRA");
    private final Leyend leyend = new Leyend();
    private final Data data = new Data();

    private Node start ;
    private Node objective;
    private Node actual;
    private final Graph graph;
    private Vector<Node> unvisited;
    private Map<Integer, Integer[]> cost = new HashMap<>(); // NodeID ->  0 ShortestPathFromStart, 1 PreviousVertexID


    public DijkstraGUI(Canvas canvas) {
        // Setting Base Config
        this.setLayout(null);
        this.setSize(1024, 720);

        //Adding All Elements
        this.canvas = canvas;
        this.add(canvas);
        this.graph = canvas.getGraph();

        this.add(chooseStartButton);
        this.add(chooseObjectiveButton);
        this.add(switchGraphButton);
        this.add(resetGraphButton);
        this.add(initAlgorithmButton);
        this.add(backButton);

        this.add(title);
        this.add(leyend);
        this.add(data);


        // Setting Buttons Location and Size
        this.chooseStartButton.setBounds(720, 70, 290, 60);
        this.chooseObjectiveButton.setBounds(720, 140, 290, 60);
        this.switchGraphButton.setBounds(720, 475, 290, 60);
        this.resetGraphButton.setBounds(720,545,290,60);
        this.initAlgorithmButton.setBounds(720, 615, 142, 55);
        this.backButton.setBounds(870,615,143   ,55);


        unvisited = new Vector<> (graph.getNodeList());
        for (Node node : graph.getNodeList()) {
            cost.put(node.getIdentifier(), new Integer[]{Integer.MAX_VALUE, -1});
        }

        // Setting Buttons Events
        chooseStartButton.addActionListener(mousePressed -> {
            if(start != null){start.setColor(Color.GRAY);}
            start = canvas.getSelectedNode();
            actual = start;
            System.out.println("START IN GUI = " + start.getIdentifier());
            if (start != null){
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
            if(objective != null){objective.setColor(Color.GRAY);}
            objective = canvas.getSelectedNode();
            System.out.println("OBJECTIVE IN GUI = " + objective.getIdentifier());
            if (objective != null){
                data.setObjective(String.valueOf(objective.getIdentifier()));
                objective.setColor(Color.GREEN);
            }
            canvas.repaint();
        });

        initAlgorithmButton.addActionListener( mousePressed -> {
            if (unvisited.contains(objective)){
                if (unvisited.contains(actual)){
                    // Revisar Todas las conxeiones
                    for(Node n: actual.getAllAccessNodes()){
                        int visitedId = n.getIdentifier();
                        Link linkActualToN = (Link) actual.undirectedMap.get(n.getIdentifier())[1];
                        int shortestPathFromStart = cost.get(actual.getIdentifier())[0] + linkActualToN.getDistance();

                        if (cost.get(n.getIdentifier())[0] > shortestPathFromStart || cost.get(n.getIdentifier())[1] == -1) {
                            cost.put(visitedId, new Integer[]{shortestPathFromStart, actual.getIdentifier()});
                        }
                    }
                        unvisited.removeElement(actual);
                        actual.setColor(Color.YELLOW);
                } else {
                    int lowerDistance = Integer.MAX_VALUE;
                    for (Node k : unvisited) {
                        if (cost.get(k.getIdentifier())[0] < lowerDistance) {
                            actual = k;
                            lowerDistance = cost.get(k.getIdentifier())[0];
                        }
                    }
                    actual.setColor(Color.PINK);
                }
            } else {
                StringBuilder path = new StringBuilder("" + objective.getIdentifier());
                graph.getNodeList().get(start.getIdentifier()).setColor(Color.GREEN);

                int objectiveInt = objective.getIdentifier();
                while (objectiveInt != start.getIdentifier()) {
                    graph.getNodeList().get(objectiveInt).setColor(Color.GREEN);
                    objectiveInt = cost.get(objectiveInt)[1];
                    path.insert(0, objectiveInt + " => ");
                    System.out.println(path.toString());
                }
                System.out.println("FINISHED: " + path);
                data.setOptimalPath(path.toString());
            }
            canvas.repaint();
        });

        resetGraphButton.addActionListener( mousePressed -> {
            canvas.reset();
            start = canvas.getSelectedNode();
            data.setStart("");
            data.setObjective("");
            data.setOptimalPath("  C a m i n o   O p t i m o");
            canvas.repaint();
        });


    }

    static class Title extends JPanel {
        String title ;
        public Title(String title){
            this.title = title;
            this.setLayout(null);
            this.setBounds(720,10,290,40);
        }

        public void paint(Graphics g){
            g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
            g.drawString(this.title,2,30);
        }

    }

    static class Leyend extends JPanel {
        public Leyend(){
            this.setLayout(null);
            this.setBounds(720,210,290,136);
        }
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D gGray = (Graphics2D) g;
            Graphics2D gGreen = (Graphics2D) g;
            Graphics2D gYellow = (Graphics2D) g;
            Graphics2D gPink = (Graphics2D) g;
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(0,0,289,135);
            g.setColor(Color.BLACK);
            g.drawRect(0,0,289,135);
            gGray.setColor(Color.GRAY);
            gGray.fillRect(1, 1, 32, 33);
            gGreen.setColor(Color.GREEN);
            gGreen.fillRect(1, 35, 32, 33);
            gYellow.setColor(Color.YELLOW);
            gYellow.fillRect(1, 69, 32, 33);
            gPink.setColor(Color.PINK);
            gPink.fillRect(1, 103, 32, 32);

            g.setColor(Color.BLACK);
            g.drawLine(0, 34, 289, 34);
            g.drawLine(0, 68, 289, 68);
            g.drawLine(0, 102, 289, 102);
            g.drawLine(32, 0, 32, 135);
            g.setFont(new Font("Fira Code SemiBold", Font.PLAIN, 18));
            g.drawString("NO REVISADAS", 95, 25);
            g.drawString("OBJETIVO / RUTA OPTIMA", 45, 60);
            g.drawString("REVISADOS", 110, 90);
            g.drawString("NODO ACTUAL", 95, 125);
        }
    }

    static class Data extends JPanel {

        String start = "";
        String objective = "";
        String optimal = "  C a m i n o   O p t i m o";

        public Data() {
            this.setLayout(null);
            this.setBounds(720, 355, 290, 111);
        }
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g.setFont(new Font("Fira Code SemiBold", Font.BOLD, 23));
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(0,0,289,110);
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, 289, 110);
            g.drawLine(0,37,289,37);
            g.drawLine(0,74,289,74);
            g.drawString("Nodo Inicial: ", 5, 30 );
            g.drawString(this.start, 180, 30 );
            g.drawString("Nodo Objetivo: ", 5, 60 );
            g.drawString(this.objective, 180, 60 );
            g.drawString(this.optimal, 5, 100 );
        }
        public void setStart(String start){
            this.start = start;
            repaint();
        }
        public void setObjective(String objective){
            this.objective = objective;
            repaint();
        }
        public void setOptimalPath(String path){
            this.optimal = path;
            repaint();
        }
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas(Predefined.graphNumber1());
        DijkstraGUI D = new DijkstraGUI(canvas);
        JFrame window = new JFrame("Graphs");
        window.add(D);
        window.setSize(1024, 720);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
