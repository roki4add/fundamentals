package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<Character,Integer> countChars = new LinkedHashMap<>();

        String input = scan.nextLine();

        for (char symbol:input.toCharArray()) {
            if (symbol == ' '){
                continue;
            }
            if (countChars.containsKey(symbol)){
                int count = countChars.get(symbol);
                countChars.put(symbol,count+1);
            }else {
                countChars.put(symbol,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
