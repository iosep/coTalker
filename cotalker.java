package cotalker;

import java.util.ArrayList;

/**
 *
 * @author iosep (José Oñate)
 */
public class CoTalker {

    public static void main(String[] args) {
        /*Se tiene un arreglo de listas. Ej: [[1,3],[‘a’],[4,5]] 
        Se desea obtener todas las permutaciones entre las listas. 
        La respuesta para este ejemplo es: 1a4 1a5 3a4 3a5. 
        Escribe un programa que se capaz de generar las permutaciones. 
Ejemplos: 
        Input [[1],[2,3]] -> Output 12 13 ; 
        Input [['a'],['b'],['c'],[1,2,3]] -> Output abc1 abc2 abc3*/

        char[][] input = {{'1', '3'}, {'a', 'b', 'c'}, {'5', '7'}, {'z'}, {'2', '4', '8'}};
        //char[][] input = {{'1', '3'}, {'a'}, {'4', '5'}};
        //char[][] input = {{'a'}, {'b'}, {'c'}, {'1', '2', '3'}};
        int cantListas = input.length;
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> output2 = new ArrayList<>();
        String aux = "";
        int loop = 0;
        int lastList = cantListas - 1;
        int pos = lastList;
        int count = 0;
        int cantComb = 1;
        for (char[] lista : input) {
            cantComb *= lista.length;
        }

        while (cantComb > 0) {
            if (loop < input[lastList].length) {
                for (char[] lista : input) {
                    aux += lista[0];
                }
                output.add(aux);
                loop++;
                System.out.println(++count + ". " + aux);
                cantComb--;
                for (int k = 1; k < input[lastList].length; k++) {
                    aux = aux.substring(0, lastList) + input[lastList][k];
                    output.add(aux);
                    loop++;
                    System.out.println(++count + ". " + aux);
                    cantComb--;
                }
                pos--;
                output2.addAll(output);
            } else if (input[pos].length > 1) {
                for (int k = 1; k < input[pos].length; k++) {
                    for (int l = 0; l < output.size(); l++) {
                        StringBuilder sb = new StringBuilder(output.get(l));
                        sb.setCharAt(pos, input[pos][k]);
                        output2.add(sb.toString());
                        cantComb--;
                        System.out.println(++count + ". " + sb);
                    }
                }
            }
            pos--;
            output.clear();
            output.addAll(output2);
        }
        System.out.println("::Output ArrayList::");
        System.out.println(output);
    }
}
