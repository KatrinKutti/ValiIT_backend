package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson2controller {

    //http://localhost:8080/Katrin/ex1web?array=9,8,4,3,2,1,4,6,7
    @GetMapping("ex1web")
    public int[] ex1web(int[]array) {
        return Lesson2.exercise1Web(array);
    }

    //http://localhost:8080/Katrin/fibonacci?n=10
    @GetMapping("fibonacci")
    public int fibonacci(@RequestParam ("n") int n) {
        return Lesson2.exercise4(n);
    }

    //http://localhost:8080/Katrin/exercise5?x=1&y=10
    @GetMapping("exercise5")
    public String exercise5(@RequestParam ("x") int x, @RequestParam ("y") int y){
        return Lesson2.exercise5(x,y);
    }
}
