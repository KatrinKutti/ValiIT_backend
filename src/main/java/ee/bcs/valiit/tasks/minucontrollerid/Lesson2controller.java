package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson2controller {

    //http://localhost:8080/Katrin/fibonacci?n=10
    @GetMapping("fibonacci")
    public int fibonacci(@RequestParam ("n") int n) {
        return Lesson2.exercise4(n);
    }
}
