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
        int start = numbers[0]; //võtab esimese numbri
        int end = numbers[numbers.length - 1]; //võtab viimase numbri ja lahutab ühe, et saada jadas eelviimane number
        int[] newNumber = new int[end - start + 1];//seab uue numbri kohale
        for (int i = 0; i < newNumber.length; i++) {
            newNumber[i] = start;
            start += 1;
        }
        return newNumber;
    }

    //Complete the square sum function so that it squares each number passed into it and then sums the results together.
    //For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.
    public static int squareSum(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i] * n[i];
        }
        return sum;
    }

    //Complete the function that accepts a string parameter, and reverses each word in the string.
    // All spaces in the string should be retained.
    //"This is an example!" ==> "sihT si na !elpmaxe"
    //"double  spaces"      ==> "elbuod  secaps"

//    public static String reverseWords(final String original){

}




