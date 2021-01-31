package ee.bcs.valiit.tasks;

import java.util.concurrent.LinkedTransferQueue;

public class Lesson1MathUtil {
    private String test;

    // TODO kirjuta ise (if/else) ära kasuta java.lang.Math
    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
//        System.out.println(min(6, 9));
//        System.out.println(max(56, 5));
//        System.out.println(abs(3));
        System.out.println(isEven(8));
//        System.out.println(min(10, 9, 6));
//        System.out.println(max(5, 5, 4));


    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }

    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        return Math.abs(a);
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min(int a, int b, int c) {
        int i = 0;
        if (a < b && a < c) {
            i = a;
        }
        if (b < a && b < c) {
            i = b;
        }
        if (c < a && c < b) {
            i = c;
        }
        return i;
    }


    // TODO tagasta kolmest arvust kõige suurem
    public static int max(int a, int b, int c) {
        int i = 0;
        if (a >= b && a >= c) {
            i = a;
        } else if (b >= a && b >= c) {
            i = b;
        } else if (c >= a && c >= b) {
            i = c;
        }
        return i;

    }
}
