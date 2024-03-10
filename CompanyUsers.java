package AssociativeArraysExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> employeeList = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")){

            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            if (!employeeList.containsKey(company)){
                employeeList.put(company,new ArrayList<>());
                employeeList.get(company).add(employeeId);
            }else {
                List<String> currentEmployee = employeeList.get(company);
               if (!currentEmployee.contains(employeeId)){
                   currentEmployee.add(employeeId);
               }
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String,List<String>> entry : employeeList.entrySet()) {
            System.out.printf("%s\n", entry.getKey());
            entry.getValue().forEach(id -> System.out.printf("-- %s\n", id));
        }
    }
}
