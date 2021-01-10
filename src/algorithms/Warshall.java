package algorithms;

import graph.Graph;
import graph.Node;

import java.util.Vector;

public class Warshall {

    public static Vector<Vector<Vector<Integer>>> warshallAlgorithm(Graph graph) {
        Vector<Vector<Integer>> warshallMatrix = new Vector<>(1, 1);
        Vector<Node> nodesList = graph.getNodeList();
        Vector<Vector<Vector<Integer>>> allTransitiveMatrix = new Vector<>(1,1);

        for (Node node1: nodesList) {
            Vector<Integer> auxIntegers = new Vector<>(1, 1);

            for (Node node2: nodesList ) {
                if (node2.getAccessByMap().containsKey(node1.getIdentifier())) {
                    auxIntegers.add(1);
                } else {
                    auxIntegers.add(0);
                }
            }
            warshallMatrix.add(auxIntegers);
        }
        allTransitiveMatrix.add(new Vector<>(warshallMatrix));

        for(byte k=0; k < nodesList.size(); k++){
            for(byte i=0; i < warshallMatrix.size(); i++){
                for(byte j=0; j < warshallMatrix.size(); j++){
                    if(i == k || j == k){
                        continue;
                    }
                    if(warshallMatrix.get(k).get(i) == 1 && warshallMatrix.get(j).get(k) == 1){
                        Vector<Integer> aux = new Vector<>(warshallMatrix.get(j));
                        aux.set(i, 1);
                        warshallMatrix.set(j, aux);
                    }
                }
            }
            allTransitiveMatrix.add(new Vector<>(warshallMatrix));
        }
        return allTransitiveMatrix;
    }
}
