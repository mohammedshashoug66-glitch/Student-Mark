import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int studentCount = readPositiveInt(scanner, "How many students do you want to enter? ");

        for (int i = 1; i <= studentCount; i++) {
            System.out.println("\n--- Entering details for Student #" + i + " ---");

            System.out.print("Enter Registration Number: ");
            String regNumber = scanner.nextLine().trim();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            int age = readPositiveInt(scanner, "Enter Age: ");
            double mark1 = readValidMark(scanner, "Enter Mark 1 (0 - 100): ");
            double mark2 = readValidMark(scanner, "Enter Mark 2 (0 - 100): ");
            double mark3 = readValidMark(scanner, "Enter Mark 3 (0 - 100): ");

            Student student = new Student(regNumber, name, age, mark1, mark2, mark3);
            students.add(student);
        }

        System.out.println("\n========== ALL STUDENTS REPORT ==========");
        for (Student student : students) {
            student.displayInformation();
        }

        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a number greater than 0.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // clear invalid token
            }
        }
    }

    private static double readValidMark(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double mark = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                if (mark >= 0 && mark <= 100) {
                    return mark;
                }
                System.out.println("Mark must be between 0 and 100. Try again.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric mark.");
                scanner.nextLine(); // clear invalid token
            }
        }
    }
}