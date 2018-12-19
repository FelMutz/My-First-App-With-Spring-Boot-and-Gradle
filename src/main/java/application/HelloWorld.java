package application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "Teste")
public class HelloWorld {

    @GetMapping
    public String Hello (){
        return "Hello World";
    }


}
