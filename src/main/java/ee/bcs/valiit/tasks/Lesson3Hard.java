package ee.bcs.valiit.tasks;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main(String[] args) {
//        System.out.println(evenFibonacci(12));
//        randomGame();
        System.out.println(morseCode("katrin"));


    }

    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
    // vahetab ära n'ide väärtused vastavalt fib jadale fib(n) = fib(n-1) + fib(n-2)
    public static int evenFibonacci(int x) {

        int n1 = 1;
        int n2 = 1;
        int count = 0;
        int sum = 0;
        while (count < x) {
            int n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
            count++;
            if (n1 % 2 == 0) {
                sum += n1;
            }
            System.out.println(n1 + " ");

        }
        return sum+=n2;
    }

    // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void randomGame() {
        Random random = new Random();
        int number = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Arva ära õige number vahemikus 0-100. Sul on 10 võimalust. Sisesta number: ");
        int guess = 0;
        int i = 0;
        int count = 0;
        boolean rightNumber = false;
        while (rightNumber == false) {
            guess = scanner.nextInt();
            count++;
            if (guess == number) {
                System.out.println("Õige! Arvasid numbri ära " + count + " katsega");
            } else if (count >= 10){
                System.out.println("Oled juba " + count + " korda pakkunud, aga õiget numbrit ei leidnud");
                return;
            } else if (number <= guess) {
                System.out.println("Number ei olnud õige. Sinu pakutud number on suurem. Proovi uuesti.");
            } else if (number >= guess) {
                System.out.println("Number ei olnud õige. Sinu pakutud number on väiksem. Proovi uuesti.");
            }
        }
    }

    public static void randomGame1() {
        Random random = new Random();
        int number = random.nextInt(100);
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Arva ära õige number vahemikus 0-100. Sul on 10 võimalust. Sisesta number: ");
        int guess = 0;
        int i = 0;
        int count = 0;
        boolean rightNumber = false;
        while (rightNumber == false) {
//            guess = scanner.nextInt();
            count++;
            if (guess == number) {
                System.out.println("Õige! Arvasid numbri ära " + count + " katsega");
            } else if (count >= 10){
                System.out.println("Oled juba " + count + " korda pakkunud, aga õiget numbrit ei leidnud");
                return;
            } else if (number <= guess) {
                System.out.println("Number ei olnud õige. Sinu pakutud number on suurem. Proovi uuesti.");
            } else if (number >= guess) {
                System.out.println("Number ei olnud õige. Sinu pakutud number on väiksem. Proovi uuesti.");
            }
        }
    }
    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
    // Kasuta sümboleid . ja -
    public static String morseCode(String text) {
        Map<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c', "-.-.");
        morse.put('d', "-..");
        morse.put('e', ".");
        morse.put('f', "..-.");
        morse.put('g', "--.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".---");
        morse.put('k', "-.-");
        morse.put('l', ".-..");
        morse.put('m', "--");
        morse.put('n', "-.");
        morse.put('o', "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s', "...");
        morse.put('t', "-");
        morse.put('u', "..-");
        morse.put('v', "...-");
        morse.put('w', ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put(' ', " ");

        String sisend = "";
        for( int i = 0; i<text.length(); i++){
            Character currChar = text.charAt(i);
            sisend = sisend + morse.get(currChar) + " ";
        }
        return sisend;
    }
}
