package matriz.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matriz {

    public static void matriz(){
        Scanner scan = new Scanner(System.in);
        System.out.println();

        int l = scan.nextInt();
        int c = scan.nextInt();


        System.out.print("What is the size od the matriz? Ex. '2 3'");

        System.out.println();


        Integer[][] matriz = new Integer[l][c];


        System.out.println("Insert Numbers:");
        System.out.println();
        for (int i = 0; i<matriz.length; i++){
            System.out.printf("Insert numbers of line %d: Ex '1 2 3'",i);
            for (int j = 0; j<matriz[i].length; j++){
                matriz[i][j] = scan.nextInt();
            }
        }

        System.out.print("Find a specific number and see the numbers that are in its area: ");
        int find = scan.nextInt();

        for (int i = 0; i<matriz.length; i++){
            for (int j = 0; j<matriz[i].length; j++){
                if(matriz[i][j] == find) {
                    System.out.println();
                    System.out.println("Position " +i+ "," +j+":");
                    if (j > 0)
                        System.out.printf("Left: %d%n", matriz[i][j - 1]);
                    if (j < matriz[i].length-1)
                        System.out.printf("Right: %d%n", matriz[i][j + 1]);
                    if (i > 0)
                        System.out.printf("Up: %d%n", matriz[i - 1][j]);
                    if (i < matriz.length-1)
                        System.out.printf("Down: %d%n", matriz[i + 1][j]);
                }
            }
        }

        System.out.println();
        System.out.println("Main diagonal:");

        IntStream.range(0, matriz.length)
                .forEach(i -> System.out.println(matriz[i][i]));

        scan.close();
    }

}
