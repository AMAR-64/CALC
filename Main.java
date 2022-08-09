package CALC;

import java.util.*;


    public class Main {
        public static void main (String[] args) throws IndexOutOfBoundsException {
//            args = new String[]{"IX","*","IX"};

            String[] rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            List <String> romList = new ArrayList<>(Arrays.asList(rom));

            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            List <String> arabList = new ArrayList<>(Arrays.asList(arab));

            String[] znak = {"+", "-", "/", "*"};
            List <String> znakList = new ArrayList<>(Arrays.asList(znak));


            if (romList.contains(args[0]) && romList.contains(args[2]) && znakList.contains(args[1])) {
//                System.out.println("Римские цифры: " + args[0] + " " + args[1] + " " + args[2] );
                romRezult (args[0], args[1], args[2]);
            }
            else if (arabList.contains(args[0]) && arabList.contains(args[2]) && znakList.contains(args[1])) {
//                System.out.println("Арабские цифры: " + args[0] + " " + args[1] + " " + args[2]);
                arabRezult (args[0], args[1], args[2]);
            }
            else { throw new IndexOutOfBoundsException (" Ошибка ввода "); }

        }

        public static void arabRezult (String a, String b, String c) {
            int number01 = Integer.parseInt(a);
            int number02 = Integer.parseInt(c);
            switch (b) {
                case "+": System.out.println(number01 + number02); break;
                case "-": System.out.println(number01 - number02); break;
                case "/": System.out.println(number01 / number02); break;
                case "*": System.out.println(number01 * number02); break;
            }
        }

        public static void romRezult (String a, String b, String c) throws NumberFormatException {
            String[] rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            int chislo_a = 0;
            int chislo_с = 0;
            for (int i=0; i<10; i++) {
                if (rom[i].equals(a)) {
                    chislo_a = i + 1;
                }
            }
            for (int p=0; p<10; p++) {
                if (rom[p].equals(c)) {
                    chislo_с = p + 1;
                }
            }
            int arab = 0;
            switch (b) {
                case "+": arab = chislo_a + chislo_с; break;
                case "-": arab = chislo_a - chislo_с; break;
                case "/": arab = chislo_a / chislo_с; break;
                case "*": arab = chislo_a * chislo_с; break;
            }
            if (arab < 1) {
                throw new NumberFormatException ("В римской системе нет отрицательных чисел");
            }
            System.out.println(arabVrom(arab));
        }

       public static String arabVrom (int arabChislo) {
           int[] arab = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
           String[] rom = new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
           StringBuilder romChislo = new StringBuilder();
           for (int i = 0; i < arab.length; i++ ) {
               while (arabChislo >= arab[i]) {
                   arabChislo -= arab[i];
                   romChislo.append(rom[i]);
               }
           }
           return romChislo.toString();
       }
    }