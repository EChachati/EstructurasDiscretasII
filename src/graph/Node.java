package graph;

import java.awt.*;
import java.util.*;

public class Node {
    private final int x;
    private final int y;
    public static final int diameter = 40;
    public static int id = 0;
    private final int identifier;
    protected Map<Integer,Object[]> accessMap; // 0 = Node, 1 = Link
    protected Map<Integer,Object[]> accessedByMap; // 0 = Node, 1 = Link
    public final Map<Integer,Object[]> undirectedMap; // 0 = Node, 1 = Link
    private Color color = Color.GRAY;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        identifier = id;
        id++;
        accessMap = new HashMap();
        accessedByMap = new HashMap();
        undirectedMap =  new HashMap();
    }

    /*
     * Everytime invoked will draw a circle at clicked position
     * */
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.drawOval(this.x - diameter/2,this.y - diameter/2, diameter, diameter);
        g2.fillOval(this.x - diameter/2,this.y - diameter/2, diameter, diameter);

        Font font = new Font("",Font.BOLD,30);
        g3.setColor(Color.BLACK);
        g3.setFont(font);
        g3.drawString(Integer.toString(identifier) , x-7, y+10);
    }

    public Rectangle getOval(){ return new Rectangle(this.x - diameter/2,this.y - diameter/2, diameter, diameter); }

    public int getIdentifier() { return identifier; }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setColor(Color color) { this.color = color; }

    public Color getColor() { return color; }

    public Map<Integer, Object[]> getAccessByMap(){ return this.accessedByMap; }

    public Collection<Node> getAllAccessNodes() {
        Vector<Node> accessNodes = new Vector<>();
        for(Map.Entry<Integer, Object[]> entry: undirectedMap.entrySet()){
            accessNodes.add((Node) entry.getValue()[0]);
        }
        return accessNodes;
    }

    public Collection<Link> getAllAccessLinks(){
        Vector<Link> access = new Vector<>();
        for(Map.Entry<Integer, Object[]> entry: undirectedMap.entrySet()){
            access.add((Link) entry.getValue()[1]);
        }
        return access;
    }

    public String toString(){

        StringBuilder accessTo = new StringBuilder("\nHave access to: \n");
        if (accessMap.isEmpty()){
            accessTo.append("   NO ONE\n");
        } else {
            for (Map.Entry<Integer, Object[]> e : accessMap.entrySet()) {
                accessTo.append("   Node ").append(e.getKey()).append(", Cost: ");
                if (e.getValue()[1] instanceof Link) {
                    accessTo.append(((Link) e.getValue()[1]).getDistance()).append("\n");
                }
            }
        }

        StringBuilder accessBy = new StringBuilder("Accessed by: \n");
        if (accessedByMap.isEmpty()){
            accessBy.append("   NO ONE\n");
        } else {
            for (Map.Entry<Integer, Object[]> e : accessedByMap.entrySet()) {
                accessBy.append("   Node ").append(e.getKey()).append(", Cost: ");
                if (e.getValue()[1] instanceof Link) {
                    accessBy.append(((Link) e.getValue()[1]).getDistance()).append("\n");
                }
            }
        }
        return "id = "+ identifier + "\nX=" + x + "  Y=" + y + accessTo + accessBy ;
    }
}
