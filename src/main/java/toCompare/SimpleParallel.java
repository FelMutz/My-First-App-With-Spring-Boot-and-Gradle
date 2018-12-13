package toCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SimpleParallel {

    private static List<String> list = new ArrayList<String>();

    public static List<String> simpleParallel(){

        long num = 1000000L; //maximo que a Stream parallel consegue rodar nesta maquina
        //long num = 10000000000L;
        list.clear();
        list.add("simpleParallel");
        list.add("");

        sumWithFor(num); //chama uma função estática passando o valor num por parametro
        sumWithStreamSimple(num);
        sumWithStreamParallel(num);
        sumWithLongStreamSimple(num);
        sumWithLongStreamParallel(num);
        return list;
    }

    public static void sumWithFor(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        for(long i = 1l; i<num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();

        list.add("For: Result: "+result+" Time: "+(end-init)+" ms");
    }

    public static void  sumWithStreamSimple(long num){
        long result =0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("Stream Simple: Result: "+result+" Time: "+(end-init)+" ms");

    }

    public static void  sumWithStreamParallel(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("Stream Parallel: Result: " + result + " Time: " + (end - init) + " ms");

    }

    public static void  sumWithLongStreamSimple(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("LongStream Simple: Result: "+result+" Time: "+(end-init)+" ms");
    }

    public static void  sumWithLongStreamParallel(long num){
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("LongStream Parallel: Result: "+result+" Time: "+(end-init)+" ms");
    }
}
