package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson3HardTest {

    @Test
    void evenFibonacci() {
        assertEquals(133, Lesson3Hard.evenFibonacci(10));
        assertEquals(5, Lesson3Hard.evenFibonacci(3));
    }

    @Test
    void morseCode() {
        assertEquals("-.- .- - .-. .. -. ", Lesson3Hard.morseCode("katrin"));
    }
}