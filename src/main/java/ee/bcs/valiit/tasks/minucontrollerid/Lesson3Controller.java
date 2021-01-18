package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson3Controller {

    @GetMapping("sum")
    public int sum(@RequestParam("array") int[]array){
        return Lesson3.sum(array);
    }
}
