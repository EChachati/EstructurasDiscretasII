package gui.warshall;

import algorithms.Warshall;
import graph.Predefined;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Matrix extends JPanel {

    private final int DEFAULT_WIDTH;
    private final int DEFAULT_HEIGHT;

    private int width = 0;
    private int height = 0;
    private Vector<Vector<Vector<Integer>>> allTransitiveMatrix;
    private final Vector<Vector<Integer>> matrix;
    private final int nodeQuantity;

    public Matrix(Vector<Vector<Vector<Integer>>> allTransitiveMatrix, int n){
        setLayout(null);
        setSize(700,700);
        this.allTransitiveMatrix = allTransitiveMatrix;
        this.matrix = allTransitiveMatrix.get(n);
        this.nodeQuantity = matrix.size();
        DEFAULT_HEIGHT = 660 / (nodeQuantity+1);
        DEFAULT_WIDTH = 700 / (nodeQuantity+1);
    }

    public Matrix (Vector<Vector<Integer>> matrix){
        setLayout(null);
        setSize(700,700);
        this.matrix = matrix;
        nodeQuantity = matrix.size();
        DEFAULT_HEIGHT = 660 / (nodeQuantity+1);
        DEFAULT_WIDTH = 700 / (nodeQuantity+1);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.LIGHT_GRAY);
        g3.fillRect(0,0,699,699);
        width = -DEFAULT_WIDTH;
        height = 0;
        g2.setColor(Color.GREEN);
        g.setFont(new Font("", Font.BOLD, 25));
        for (int i = 0; i < matrix.size(); i++) {
            width = 0;
            height += DEFAULT_HEIGHT;
            for (int j = 0; j < matrix.size(); j++){
                if(i == 0 ) {
                    g.setColor(Color.BLACK);
                    g.drawString(Integer.toString(j), width + (DEFAULT_WIDTH + (DEFAULT_WIDTH /2)), height - (DEFAULT_HEIGHT /2));
                }
                if (j == 0){
                    g.setColor(Color.BLACK);
                    g.drawString(Integer.toString(i), width + (DEFAULT_WIDTH/2), height + (DEFAULT_HEIGHT/2));
                }
                width += DEFAULT_WIDTH;
                if(matrix.get(i).get(j) == 1){
                    g2.setColor(Color.GREEN);
                    g2.fillRect(width, height, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                }
            }
        }

        g.setColor(Color.BLACK);
        width = 0; height = 0;
        for(int i = 0; i < nodeQuantity+1; i++){
            g.drawLine(width,0, width,700);
            g.drawLine(0, height, 700, height);
            width += DEFAULT_WIDTH;
            height += DEFAULT_HEIGHT;
        }
        g.drawRect(0,0,699,699);
    }

    public Matrix getEmptyMatrix() {
        Vector<Vector<Integer>> matrix = new Vector<>();
        Vector<Integer> vector = new Vector<>();
        for (byte i = 0; i < nodeQuantity; i++) {
            vector.add(0);
        }for (byte i = 0; i < nodeQuantity; i++) {
            matrix.add(vector);
        }
        return new Matrix(matrix);

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Vector<Vector<Vector<Integer>>> allTransitiveMatrix = Warshall.warshallAlgorithm(Predefined.graphNumber1());
        Matrix mat = new Matrix(allTransitiveMatrix, 6);
        window.add(mat);
        window.setSize(700, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        mat.repaint();
    }
}
