package algorithms;

import java.util.Vector;

public class VectorMethods {

    static void showMatrix(Vector<Vector <Integer>> matrix) {

        for (byte i = 0; i < matrix.size(); i++) {

            for (byte j = 0; j < matrix.size(); j++){

                System.out.printf("%7s",matrix.get(i).get(j));
            }
            System.out.println("");
        }

    }
}
