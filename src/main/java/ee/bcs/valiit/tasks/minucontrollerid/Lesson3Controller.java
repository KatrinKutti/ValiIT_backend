package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Katrin")
@RestController
public class Lesson3Controller {

    //http://localhost:8080/Katrin/sum?x=2,6,8
    @GetMapping("sum")
    public int sum(@RequestParam int[] x) {
        return Lesson3.sum(x);
    }

    //http://localhost:8080/Katrin/faktor?x=5
    @GetMapping("faktor")
    public int faktor(@RequestParam("x") int x) {
        return Lesson3.factorial(x);
    }

    //http://localhost:8080/Katrin/sort?a=2,6,8,9,4,3,7
    @GetMapping("sort")
    public int [] sort(@RequestParam int[] a){
        return Lesson3.sort(a);
    }

    //http://localhost:8080/Katrin/sort2?array=2,6,8,9,4,3,7
    @GetMapping("sort2")
    public int [] sort2(@RequestParam int[] array){
        return Lesson3.sort(array);
    }

    //http://localhost:8080/Katrin/reverseString?a=Katrin
    @GetMapping("reverseString")
    public String reverseString(@RequestParam String a){
        return Lesson3.reverseString(a);
    }

    //http://localhost:8080/Katrin/isPrime?x=3
    @GetMapping("isPrime")
    public boolean isPrime(@RequestParam int x){
        return Lesson3.isPrime(x);
    }


}
