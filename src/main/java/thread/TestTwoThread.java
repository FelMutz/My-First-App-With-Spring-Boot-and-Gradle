package thread;

import java.util.ArrayList;
import java.util.List;

public class TestTwoThread {

    private static int i = 0;
    private static List<String> list = new ArrayList<String>();

    public static List<String> testTwoThread (){
        list.clear();
        list.add("testTwoThread");
        list.add("");

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();

        while (thread1.isAlive() ==true || thread2.isAlive() == true){

        }
        return list;
    }

    private static void countMe(String name){
        i++;
        list.add("Current Counter is: " + i + ", updated by: " + name);
        System.out.println(Thread.currentThread().getName());
    }

    private static Runnable t1 = () -> {
        try{
            for(int i=0; i<5; i++){
                countMe("t1");
            }
        } catch (Exception e){}

    };

    private static Runnable t2 = () -> {
        try{
            for(int i=0; i<5; i++){
                countMe("t2");
            }
        } catch (Exception e){}
    };

}
