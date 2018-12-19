package thread;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
public class TestThreadStreams {
    public static long num = 1000000L;
    private static List<String> list = new ArrayList<String>();


    @SneakyThrows
    public synchronized static List<String> testThreadStreams(){
        list.clear();
        list.add("testThreadStreams");
        list.add("");

        Thread toFor = new Thread(sumWithFor); //chama uma função estática passando o valor num por parametro
        Thread simple = new Thread(sumWithStreamSimple);
        Thread parallel = new Thread(sumWithStreamParallel);
        Thread longSimple = new Thread(sumWithLongStreamSimple);
        Thread longParallel = new Thread(sumWithLongStreamParallel);

        toFor.start();
        simple.start();
        parallel.start();
        longSimple.start();
        longParallel.start();

        toFor.join();
        simple.join();

//        while (toFor.isAlive() ==true|| simple.isAlive()==true|| parallel.isAlive()==true|| longSimple.isAlive()==true||longParallel.isAlive()==true){
//
//        }
        return list;

    }

    public static Runnable sumWithFor = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        for(long i = 1l; i<num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();

        list.add("For: Result: "+result+" Time: "+(end-init)+" ms");

    };

    public static Runnable sumWithStreamSimple = () ->{
        long result =0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("Stream Simple: Result: "+result+" Time: "+(end-init)+" ms");
    };

    public static Runnable sumWithStreamParallel = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        result = Stream.iterate(1l, i->i+1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("Stream Parallel: Result: "+result+" Time: "+(end-init)+" ms");

    };

    public static Runnable sumWithLongStreamSimple = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("LongStream Simple: Result: "+result+" Time: "+(end-init)+" ms");
    };

    public static Runnable sumWithLongStreamParallel = () ->{
        long result = 0;

        long init = System.currentTimeMillis();
        result = LongStream.range(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        list.add("LongStream Parallel: Result: "+result+" Time: "+(end-init)+" ms");
    };

}
