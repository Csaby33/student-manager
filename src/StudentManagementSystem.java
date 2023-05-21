import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    // Display the menu options
    public static void displayMenu() {
        System.out.println();
        System.out.println("Press 1 to list students");
        System.out.println("Press 2 to add students");
        System.out.println("Press 3 to update students");
        System.out.println("Press 4 to remove students");
        System.out.println("Press 5 to quit");
    }

    public static void main(String[] args) {

        while (true) {
            displayMenu();
            boolean validInput = false;
            while (!validInput) {
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer
                    processMenuChoice(choice);
                    validInput = true; // Input is valid, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        }
    }

    // Process the user's menu choice
    public static void processMenuChoice(int choice) {
        switch (choice) {
            case 1 -> StudentManager.listAllStudents();
            case 2 -> StudentManager.addNewStudent();
            case 3 -> StudentManager.updateStudentDetails();
            case 4 -> StudentManager.removeStudent();
            case 5 -> {
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid input. Please choose a number between 1-5.");
        }
    }


}
