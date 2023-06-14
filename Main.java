package Calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ");
        String input = scanner.nextLine().toUpperCase();

        Pattern patternRoman = Pattern.compile("[IVX]");
        Pattern patternOperand = Pattern.compile("[*/+-]");
        Pattern patternArabic = Pattern.compile("\\d");

        Matcher matcherArabic = patternArabic.matcher(input);
        Matcher matcherOperand = patternOperand.matcher(input);
        Matcher matcherRoman = patternRoman.matcher(input);

        if (matcherArabic.find() && matcherRoman.find() || !matcherOperand.find()) {    // Проверка на корректность ввода
            throw new Exception("используются одновременно разные системы счисления");
        }
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        String[] s = input.split(" ");
        if (s.length > 3 || s.length < 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        HelpMain helpMain = new HelpMain();

        if ((s[0].equals("I")) || (s[0].equals("II")) || (s[0].equals("III")) || (s[0].equals("IV")) || (s[0].equals("V")) || (s[0].equals("VI")) || (s[0].equals("VII")) || (s[0].equals("VIII")) || (s[0].equals("IX")) || (s[0].equals("X")) ) {
           return helpMain.goRoman(s);
        } else {
            Main main = new Main();
            String rezult = main.goArabic(s);
            return rezult;
            }
    }
    String goArabic(String[] s) throws Exception {
        String re = "";
        int one = Integer.parseInt(s[0]);
        int two = Integer.parseInt(s[2]);
        if (one > 10 || two > 10) {
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более и не менее");
        }
        int rezult = 0;
        switch (s[1]) {
            case "-" : rezult = one - two; break;
            case "+" : rezult = one + two; break;
            case "/" : rezult = one / two; break;
            case "*" : rezult = one * two; break;
        }
           re = Integer.toString(rezult);
        return re;
    }
}
