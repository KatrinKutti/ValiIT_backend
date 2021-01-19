package ee.bcs.valiit.tasks.minucontrollerid;
import ee.bcs.valiit.tasks.Lesson2;
import ee.bcs.valiit.tasks.Lesson3Hard;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RequestMapping("Katrin")
@RestController
public class Lesson3HardController {

    //http://localhost:8080/Katrin/evenFibonacci?x=10
    @GetMapping("evenFibonacci")
    public int evenFibonacci(@RequestParam ("x") int x) {
        return Lesson3Hard.evenFibonacci(x);
    }

    //http://localhost:8080/Katrin/morse?text=sos
    @GetMapping("morse")
    public String morse(@RequestParam ("text") String text){
        return Lesson3Hard.morseCode(text);
    }

    //http://localhost:8080/Katrin/randomGame?x=91
    Random random = new Random();
    int count = 0;
    int number = random.nextInt(100);
    @GetMapping("randomGame")
    public String randomGame(@RequestParam ("x") int x){
        count++;
        String answer = Integer.toString(x);
        if (x == number) {
            answer = "Õige! Arvasid numbri ära " + count + " katsega";
        } else if (count >= 10){
            answer= "Oled juba " + count + " korda pakkunud, aga õiget numbrit ei leidnud";
        } else if (number <= x) {
            answer = "Number ei olnud õige. Sinu pakutud number on suurem. Proovi uuesti.";
        } else if (number >= x) {
            answer = "Number ei olnud õige. Sinu pakutud number on väiksem. Proovi uuesti.";
        }
        return answer;
    }
}
