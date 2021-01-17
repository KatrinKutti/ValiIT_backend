package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class CodeWars8 {
    public static void main(String[] args) {
        System.out.println(position('b'));
    }

    public static int nthPower(int[] array, int n) {
        if (n < array.length) {
            int sum = array[n];
            for (int i = 1; i < n; i++) { // kui siia panna i algväärtuseks 1, siis ei pea if real lisama -1 array.length'ile
                sum *= array[n];
            }
            return sum;
        } else {
            return -1;
        }
    }

    public static int howOld(final String herOld) {
        return Integer.parseInt(herOld.substring(0, 1));
        // et saada Stringist numbriks, saab muuta Integer klassis sisendi numbriks
        // substring näitab, millisest indexist String sisendit lugema hakatakse ja millise indexi kohal  lugemine lõpetatakse

    }

    public static String position(char alphabet) {
        char[] array = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        for (int i = 0; i < array.length; i++) {
            if (alphabet == array[i]) {
                return "Position of alphabet: " + (i + 1);
            }
        }
        //if( kui sisestatud täht  == arrays toodud tähega, sii väljastab indexi, kus täht asub. Lisada tuleb 1, sest indexid algavad kohalt 0.

        return "Position of alphabet: 0";
    }
//    String letters = "abcdefghijklmnopqrstuvwxyz";
//    String position = "Position of alphabet: " + (letters.indexOf(alphabet) + 1);
//    return position;
//    lühem lahendus
//}

    // leia antud numbrite suuremast väiksemaks järjestus  ning vahede summa.
    public static int sumOfDifferences(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    number = arr[i];
                    arr[i] = arr[j];
                    arr[j] = number;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum = (int) sum + (arr[i] - arr[i + 1]);
        }
        return sum;

//            Arrays.sort(arr);
//            int s = 0;
//            for (int i = 0; i < arr.length-1; i++)
//                s += arr[i+1] - arr[i];
//            return s;
//        }
    }
    //#Task Given the a list of numbers, return the list so that the values increment by 1 for each index up to the maximum value.
    //Input: 1,3,5,6,7,8
    //Output: 1,2,3,4,5,6,7,8

    public static int[] pipeFix(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) { //kas saab kasutada enhanced for tsüklit? (käib läbi kõik elemendid, saab kasutada, kui ei ole vaja elemendi indexit leida)
            if (numbers[i] == numbers[i]) {

            }
            count++;
            count = count + (i + 1);
        }
        return numbers;
    }
}



