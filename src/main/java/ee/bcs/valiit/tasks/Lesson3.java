package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

//        test ülesanne
//        int a = 4;
//        int b = 5;
//        b = a + b;
//        a = b - a;
//        b = b - a;
//        System.out.println(a);
//        System.out.println(b);


        int[] a = {5, 9, 1, 2, 4, 8,};
        System.out.println(Arrays.toString(sort(a)));

//        System.out.println(sum(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(factorial(5));
//        System.out.println(isPrime(8));
//        System.out.println(reverseString("Katrin"));
    }

    // Todo liida kokku kõik numbrid massivis x
    public static int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;

    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int i = 1;
        int faktor = 1;
        int number = 5; // see on number, millega ma korrutan faktorit
        for (i = 1; i <= number; i++) {
            faktor = faktor * i; //  iga kord kui loopist läbi läheb, siis suurendab i, kuni jõuab numbrini ().
            //seejärel korrutada faktor läbi, mis annab faktorile uue väärtuse.
        }
        return faktor;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    // kasutatud BubbleSorti ehk et kõige suurem number tõuseb pinnale peale võrdlemist..
    public static int[] sort(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {         //kui esimene number jadas (i) on suurem kui järgmine number jadas (i+1), siis liigub number üles
                int temp = a[i - 1];       // value saab uue kõige suurema i väärtuse
                a[i - 1] = a[i];
                a[i] = temp;
                i = 0;
                count = 0;
            }
            count++;
            if (count == a.length) {
                break;
            }
        }
        return a;
    }

    public static int[] sort2(int[] array) {
        for (int j = 0; j < array.length; j++) {
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;

        // TODO tagasta string tagurpidi
        public static String reverseString (String a){
            StringBuilder stringBuilder = new StringBuilder(a);
            stringBuilder.reverse();
            return stringBuilder.toString();
        }

        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        public static boolean isPrime ( int x){
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
