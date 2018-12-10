package matriz.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrizWithLambda {
    public static void matrizWithLambda() {

        Scanner scan = new Scanner(System.in);
        List<List<Integer>> listArray = new ArrayList<>();

        IntStream.range(0, 3).forEach(value ->
                listArray.add(IntStream.range(0, 3).mapToObj(integre -> scan.nextInt()).collect(Collectors.toList()))
        );

        listArray.forEach(integers ->
                integers.forEach(integer -> System.out.println(integer))
        );

        System.out.print("Find a specific number and see the numbers that are in its area: ");
        int find = scan.nextInt();

        IntStream teste = listArray.stream().mapToInt(integers ->
                integers.stream().filter(integers1 -> integers1 == find).findAny().orElse(null)
        );

        if (teste != null) {
            System.out.println(teste.findAny().toString() + "achou");
        }

        scan.close();
    }
}
