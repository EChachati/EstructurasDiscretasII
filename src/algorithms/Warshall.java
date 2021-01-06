package algorithms;

import graph.Graph;
import graph.Node;

import java.util.Vector;

public class Warshall {

    public static Vector<Vector<Integer>> warshallAlgorithm(Graph graph) {
        Vector<Vector<Integer>> marshallMatrix = new Vector<>(1, 1);
        Vector<Node> nodesList = graph.getNodeList();

        for (Node node1: nodesList) {
            Vector<Integer> auxIntegers = new Vector<>(1, 1);

            for (Node node2: nodesList ) {

                if (node2.getAccessByMap().containsKey(node1.getIdentifier())) {
                    auxIntegers.add(1);
                } else {
                    auxIntegers.add(0);
                }

            }
            marshallMatrix.add(auxIntegers);
        }
        System.out.println("Tabla de adyacencia\n");
        VectorMethods.showMatrix(marshallMatrix);

        for(byte k=0; k < nodesList.size(); k++){

            for(byte i=0; i < marshallMatrix.size(); i++){

                for(byte j=0; j < marshallMatrix.size(); j++){
                    if(i == k || j == k){
                        continue;
                    }
                    if(marshallMatrix.get(k).get(i) == 1 && marshallMatrix.get(j).get(k) == 1){
                        Vector<Integer> aux = marshallMatrix.get(j);
                        aux.set(i, 1);
                        marshallMatrix.set(j, aux);
                    }
                }
            }
            System.out.printf("Tabla del Nodo %s\n", k);
            VectorMethods.showMatrix(marshallMatrix);
        }

        return marshallMatrix;
    }
}
