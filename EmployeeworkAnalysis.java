import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeworkAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> workHours = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int numEmp = scanner.nextInt();

        System.out.println("Enter the work hours for each employee for the week (one per line):");
        for (int i = 0; i < numEmp; i++) {
            double hours = scanner.nextDouble();
            workHours.add(hours);
        }

        Map<String, Integer> employeesByRange = new HashMap<>();
        Map<String, Double> averageHoursByRange = new HashMap<>();

        for (Double hours : workHours) {
            String range = getWorkHoursRange(hours);
            employeesByRange.put(range, employeesByRange.getOrDefault(range, 0) + 1);
            averageHoursByRange.put(range, averageHoursByRange.getOrDefault(range, 0.0) + hours / 7); // Assuming 7 days in a week
        }

        System.out.println("Work hours statistics by range:");
        for (Map.Entry<String, Integer> entry : employeesByRange.entrySet()) {
            String range = entry.getKey();
            int employees = entry.getValue();
            double averageHours = averageHoursByRange.get(range);
            System.out.println("Range: " + range + ", Employees: " + employees + ", Average Hours per Day: " + averageHours);
        }

        scanner.close();
    }

    private static String getWorkHoursRange(double hours) {
        if (hours > 40) {
            return "More than 40 hours";
        } else if (hours == 40) {
            return "Exactly 40 hours";
        } else {
            return "Less than 40 hours";
        }
    }
}
