package algorithms;

import graph.Graph;
import graph.Link;
import graph.Node;
import graph.Canvas;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Warshall {

    public static Vector<Vector<Integer>> warshallAlgorithm(Graph graph) {
        Vector<Vector<Integer>> marshall_matrix = new Vector<>(1, 1);
        Vector<Node> nodes_list = graph.getNodeList();

        for (byte i = 0; i < nodes_list.size(); i++) {
            Vector<Integer> aux_integers = new Vector<>(1, 1);

            for (byte j = 0; j < nodes_list.size(); j++) {

                if (nodes_list.get(j).getAccessByMap().containsKey(nodes_list.get(i).getIdentifier())) {
                    aux_integers.add(1);
                } else {
                    aux_integers.add(0);
                }

            }
            marshall_matrix.add(aux_integers);
        }
        System.out.println("Tabla de adyacencia\n");
        arrays_mehotds.showMatrix(marshall_matrix);

        for(byte k=0; k < nodes_list.size(); k++){

            for(byte i=0; i < marshall_matrix.size(); i++){

                for(byte j=0; j < marshall_matrix.size(); j++){
                    if(i == k || j == k){
                        continue;
                    }
                    if(marshall_matrix.get(k).get(i) == 1 && marshall_matrix.get(j).get(k) == 1){
                        Vector aux = marshall_matrix.get(j);
                        aux.set(i, 1);
                        marshall_matrix.set(j, aux);
                    }
                }
            }
            System.out.printf("Tabla del Nodo %s\n", k);
            arrays_mehotds.showMatrix(marshall_matrix);


        }


        return marshall_matrix;

    }


}
