package examPrep2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> productList = new LinkedHashMap<>();
        int sum = 0;
        String input = scan.nextLine();
        while (!input.equals("Complete")) {

            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];
            int quantity = Integer.parseInt(inputParts[1]);
            String food = inputParts[2];

            switch (command) {
                case "Receive":
                    if (quantity > 0) {
                        if (productList.containsKey(food)) {
                            int current = productList.get(food);
                            productList.put(food, quantity + current);
                        } else {
                            productList.put(food, quantity);
                        }
                    }
                    break;
                case "Sell":
                    if (!productList.containsKey(food)) {
                        System.out.printf("You do not have any %s.\n", food);
                    }else {
                        int currentQuantity = productList.get(food);
                        if (currentQuantity < quantity) {
                            System.out.printf("There aren't enough %s. You sold the last %d of them.\n", food, currentQuantity);
                            productList.remove(food);
                            sum += currentQuantity;
                        } else {
                            System.out.printf("You sold %d %s.\n", quantity, food);
                            sum += quantity;
                            if (currentQuantity - quantity == 0) {
                                productList.remove(food);
                            } else {
                                productList.put(food, currentQuantity - quantity);
                            }

                            break;
                        }
                    }

            }
            input = scan.nextLine();
        }
        productList.entrySet().forEach(entry -> System.out.printf("%s: %d\n",entry.getKey(),entry.getValue()));
        System.out.printf("All sold: %d goods\n",sum);

    }
}
