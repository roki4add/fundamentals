package examPrep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String massage = scan.nextLine();
        String regex = "([\\|\\#]{1})(?<name>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(massage);

        List<String> product = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        while (matcher.find()){
           product.add(matcher.group("name"));
           date.add(matcher.group("date"));
           calories.add(Integer.parseInt(matcher.group("calories")));
        }
        int totalCalories = calories.stream().mapToInt(Integer::intValue).sum();
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!\n",days);
        for (int i = 0; i < product.size() ; i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n",product.get(i),date.get(i),calories.get(i));
        }

    }
}
