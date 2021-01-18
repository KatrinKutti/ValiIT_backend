package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.Lesson1;
import ee.bcs.valiit.tasks.Lesson1MathUtil;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.solution.SolutionLesson1MathUtil;
import org.springframework.web.bind.annotation.*;
@RequestMapping("Katrin")
@RestController
public class TestController {
    @GetMapping("test/{name}")
    public String getHelloWorld(@PathVariable("name") String firstName, @RequestParam("name") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

//    // http://localhost:8080/solution/min?a=5&b=9
//    @GetMapping("min")
//    public int min(@RequestParam("a") int aVariable, @RequestParam("b") int bVariable){
//        return SolutionLesson1MathUtil.min(aVariable, bVariable);
//    }
//
//    // http://localhost:8080/solution/max/5/9
//    @GetMapping("max/{a}/{b}")
//    public int max(@PathVariable("a") int aVariable, @PathVariable("b") int bVariable){
//        return SolutionLesson1MathUtil.max(aVariable, bVariable);
//    }

    @GetMapping("min")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b){
        return Lesson1MathUtil.min(a,b);
    }

    @GetMapping("max")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b){
        return Lesson1.excersie1(a,b,);
    }

}


