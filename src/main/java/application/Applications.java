package application;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thread.TestThreadStreams;
import thread.TestTwoThread;
import toCompare.SimpleParallel;

import java.util.ArrayList;
import java.util.List;
@Controller
@RestController
public class Applications {


    @RequestMapping(value = "/Solicita/{Choose}", method = RequestMethod.GET)
    public static ResponseEntity aplications(@PathVariable("Choose") Integer choose){
       switch (choose){

            case 1:
                return ResponseEntity.ok(SimpleParallel.simpleParallel());

            case 2:
               return ResponseEntity.ok(TestTwoThread.testTwoThread());
            case 3:
                return ResponseEntity.ok(TestThreadStreams.testThreadStreams());

            default:
                List<String> list = new ArrayList<String>();
                list.add("Invalid choise!!");
                //return  ResponseEntity.badRequest().body(list);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
       }

    }

}
