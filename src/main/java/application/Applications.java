package application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thread.TestThreadStreams;
import thread.TestTwoThread;
import toCompare.SimpleParallel;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Applications {


    @RequestMapping(value = "/Solicita/{Choose}", method = RequestMethod.GET)
    public static List<String> aplications(@PathVariable("Choose") Integer choose){
       switch (choose){

            case 1:
                return SimpleParallel.simpleParallel();

            case 2:
               return TestTwoThread.testTwoThread();
            case 3:
                return TestThreadStreams.testThreadStreams();

            default:
                List<String> list = new ArrayList<String>();
                list.add("Invalid choise!!");
                return list;
       }

    }

}
