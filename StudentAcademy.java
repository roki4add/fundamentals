package AssociativeArraysExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> studentList = new LinkedHashMap<>();

        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String studentName = scan.nextLine();
            double studentGrade = Double.parseDouble(scan.nextLine());

            studentList.putIfAbsent(studentName,new ArrayList<>());
            studentList.get(studentName).add(studentGrade);

        }
        for (Map.Entry<String,List<Double>> entry:studentList.entrySet()) {

            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();

            double sum = grades.stream().mapToDouble(Double::doubleValue).sum();
            double average = sum/grades.size();
            if (average >= 4.5){
                System.out.printf("%s -> %.2f\n",studentName,average);
            }
        }
    }
}
