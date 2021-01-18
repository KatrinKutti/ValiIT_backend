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




}


