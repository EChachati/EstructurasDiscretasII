package evaluation_1.graph;

import java.awt.*;

public class Link {
    private final int x1, x2, y1, y2;
    private final int distance;

    public Link(Node node1, Node node2){
        this.x1 = node1.getX();
        this.y1 = node1.getY();
        this.y2 = node2.getY();
        this.x2 = node2.getX();
        Object[] accessedByAux =  {node1, this};
        Object[] accessAux = {node2, this};
        node2.accessedByMap.put(node1.getIdentifier(), accessedByAux);
        node1.accessMap.put(node2.getIdentifier(), accessAux);
        distance = (int) (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) / 20);
    }

    public Link(Node node1, Node node2, int distance){
        this.distance = distance;
        this.x1 = node1.getX();
        this.y1 = node1.getY();
        this.y2 = node2.getY();
        this.x2 = node2.getX();
        Object [] accessedByAux =  {node1, this};
        Object[] accessAux = {node2,this};
        node1.accessMap.put(node2.getIdentifier(), accessAux);
        node1.undirectedMap.put(node2.getIdentifier(),accessAux);
        node2.accessedByMap.put(node1.getIdentifier(), accessedByAux);
        node2.undirectedMap.put(node1.getIdentifier(),accessedByAux);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Font linkFont = new Font("Serif", Font.BOLD, 20);
        g2.setColor(Color.BLACK);
        g2.setFont(linkFont);
        g2.drawLine(x1, y1, x2, y2);
        g2.drawString(Integer.toString(distance),(x1+x2)/2, (y1+y2)/2);
    }

    public int getDistance() { return distance; }
}

