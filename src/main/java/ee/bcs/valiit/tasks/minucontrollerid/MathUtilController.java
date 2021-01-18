package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Lesson1MathUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class MathUtilController{
        @GetMapping("min")
        public int min(@RequestParam("a") int a, @RequestParam("b") int b) {
            return Lesson1MathUtil.min(a, b);
        }

        @GetMapping("max")
        public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
            return Lesson1MathUtil.max(a, b);
        }
    //http://localhost:8080/Katrin/abs?a=3
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int a) {
        return Lesson1MathUtil.abs(a);
    }

    //http://localhost:8080/Katrin/min?a=3&b=6&c=9
    @GetMapping("min2/{a}/{b}/{c}")
    public int min2(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c) {
        return Lesson1MathUtil.min(a, b, c);
    }

    //http://localhost:8080/Katrin/max/3,9,8
    @GetMapping("max2/{a}/{b}/{c}")
    public int max2(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c) {
        return Lesson1MathUtil.max(a, b, c);
    }

}
