package gui;

import graph.Canvas;
import graph.Node;
import graph.Predefined;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DijkstraGUI extends JPanel {
    Canvas canvas;
    JButton chooseStartButton = new JButton("Elige Nodo Inicial");
    JButton chooseObjectiveButton = new JButton("Elige Nodo Objetivo");
    JButton switchGraphButton = new JButton("Cambiar Grafo");
    JButton resetGraphButton = new JButton("Reiniciar Grafo");
    JButton initAlgorithmButton = new JButton("Iniciar");
    JButton backButton = new JButton("Volver");
    Title title = new Title("ALGORIMO DE DIJKSTRA");
    Leyend leyend = new Leyend();
    Data data = new Data();

    Node start;
    Node objective;


    public DijkstraGUI(Canvas canvas) {
        // Setting Base Config
        this.setLayout(null);
        this.setSize(1024, 720);

        //Adding All Elements
        this.canvas = canvas;
        this.add(canvas);

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



        // Setting Buttons Events
        chooseStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pressed) {
                if(start != null){start.setColor(Color.GRAY);}
                start = canvas.getSelectedNode();
                System.out.println("START IN GUI = " + start.getIdentifier());
                if (start != null){
                    data.setStart(String.valueOf(start.getIdentifier()));
                    start.setColor(Color.PINK);
                    canvas.repaint();
                }
            }
        });

        chooseObjectiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(objective != null){objective.setColor(Color.GRAY);}
                objective = canvas.getSelectedNode();
                System.out.println("OBJECTIVE IN GUI = " + objective.getIdentifier());
                if (objective != null){
                    data.setObjective(String.valueOf(objective.getIdentifier()));
                    objective.setColor(Color.GREEN);
                    canvas.repaint();
                }
            }
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

        String start = "-10";
        String objective = "-10";
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
