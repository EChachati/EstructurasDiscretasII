package algorithms;

import graph.Graph;
import graph.Node;

import java.util.Vector;

public class Warshall {

    public static Vector<Vector<Vector<Integer>>> warshallAlgorithm(Graph graph) {
        Vector<Vector<Integer>> marshallMatrix = new Vector<>(1, 1);
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
            marshallMatrix.add(auxIntegers);
        }
        allTransitiveMatrix.add(new Vector<>(marshallMatrix));

        for(byte k=0; k < nodesList.size(); k++){

            for(byte i=0; i < marshallMatrix.size(); i++){

                for(byte j=0; j < marshallMatrix.size(); j++){
                    if(i == k || j == k){
                        continue;
                    }
                    if(marshallMatrix.get(k).get(i) == 1 && marshallMatrix.get(j).get(k) == 1){
                        Vector<Integer> aux = new Vector<>(marshallMatrix.get(j));
                        aux.set(i, 1);
                        marshallMatrix.set(j, aux);
                    }
                }
            }
            allTransitiveMatrix.add(new Vector<>(marshallMatrix));


        }


        for(byte i=0; i < allTransitiveMatrix.size(); i++){

            if(i == 0){
                System.out.println("Matriz de adyacencia");
            }
            else{
                System.out.printf("Matriz del nodo %s \n",i-1);
            }
            VectorMethods.showMatrix(allTransitiveMatrix.get(i));
        }


        return allTransitiveMatrix;

    }


}
