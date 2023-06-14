package Calculator;

import java.util.HashMap;
import java.util.TreeMap;

class HelpMain {
    public String goRoman(String[] s) throws Exception{
        int result = 0;
        HashMap<String, Integer> arabhashMap = new HashMap<>();
        arabhashMap.put("I", 1);
        arabhashMap.put("II", 2);
        arabhashMap.put("III", 3);
        arabhashMap.put("IV", 4);
        arabhashMap.put("V", 5);
        arabhashMap.put("VI", 6);
        arabhashMap.put("VII", 7);
        arabhashMap.put("VIII", 8);
        arabhashMap.put("IX", 9);
        arabhashMap.put("X", 10);

        int i1 = arabhashMap.get(s[0]);
        int i2 = arabhashMap.get(s[2]);


        switch (s[1]) {
            case "*": result = i1 * i2;break;
            case "/": result = i1 / i2;break;
            case "+": result = i1 + i2;;break;
            case "-": result = i1 - i2;break;
        }
        if (result < 1) {
            throw new Exception("в римской системе нет отрицательных чисел");
        }
        return intToRoman(result);
    }

    public String intToRoman(int result) {

        TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

        String roman = "";
        int arabianKey;
        System.out.println("go");
        do {
            arabianKey = arabianKeyMap.floorKey(result);
            System.out.println(arabianKey);
            roman += arabianKeyMap.get(arabianKey);
            System.out.println(roman);
            result -= arabianKey;
            System.out.println(result);
        }while (result != 0);
            return roman;
    }
}




