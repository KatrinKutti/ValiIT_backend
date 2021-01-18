package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.Lesson2;

import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class TestController {
    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable("name") String firstName, @RequestParam("name") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }


    //http://localhost:8080/Katrin/fibonacci?n=10
    @GetMapping("fibonacci/{n}")
    public int fibonacci(@PathVariable("n") int nVariable) {
        return Lesson2.exercise4(nVariable);
    }


    @GetMapping("seqLength")
    public int seqLength(@RequestParam("n") int n) {
        return Lesson2.seqLength(n);
    }

}


