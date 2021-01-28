package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson1MathUtilTest {

    @Test
    void min() {
        assertEquals(3, Lesson1MathUtil.min(3,5));
        assertEquals(6, Lesson1MathUtil.min(10,6));
    }

    @Test
    void max() {
        assertEquals(5, Lesson1MathUtil.max(1,5));
        assertEquals(20, Lesson1MathUtil.max(10,20));
    }

    @Test
    void abs() {
        assertEquals(2, Lesson1MathUtil.abs(2));
        assertEquals(3, Lesson1MathUtil.abs(3));
    }

    @Test
    void isEven() {
        assertEquals(true, Lesson1MathUtil.isEven(8));
        assertEquals(false, Lesson1MathUtil.isEven(9));
    }

    @Test
    void testMin() {
        assertEquals(3, Lesson1MathUtil.min(3,8,11));
        assertEquals(10, Lesson1MathUtil.min(20,50,10));
    }

    @Test
    void testMax() {
        assertEquals(100, Lesson1MathUtil.max(5,60,100));
        assertEquals(3, Lesson1MathUtil.max(-9,3,-5));
    }
}