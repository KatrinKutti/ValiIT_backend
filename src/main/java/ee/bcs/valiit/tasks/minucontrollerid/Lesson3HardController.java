package ee.bcs.valiit.tasks.minucontrollerid;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson3HardController {

    //localhost:8080/Katrin/evenFibonacci/n
    @GetMapping("evenFibonacci/{n}")
    public int evenFibonacci(@PathVariable ("n") int nVariable){
        return Lesson3Hard.evenFibonacci(nVariable);
    }
}
