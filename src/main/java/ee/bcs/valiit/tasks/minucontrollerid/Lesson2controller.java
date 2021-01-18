package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson2controller {

    //http://localhost:8080/Katrin/fibonacci/10
    @GetMapping("fibonacci/{n}")
    public int fibonacci(@PathVariable("n") int nVariable) {
        return Lesson2.exercise4(nVariable);
    }
}
