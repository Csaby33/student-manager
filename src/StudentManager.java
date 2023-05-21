import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManager {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addNewStudent() {
        Student student = new Student();
        System.out.println("Please enter name: ");
        student.setName(scanner.nextLine());
        boolean isAgeValid = false;
        boolean isGradeValid = false;

        while (!isAgeValid) {
            try {

                System.out.println("Please enter age: ");
                int age = scanner.nextInt();
                if (age >= 0 && age <= 120) {
                    student.setAge(age);
                    isAgeValid = true;
                } else {
                    System.out.println("Invalid age. Age must be between 0 and 120.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input

            }
        }

        while (!isGradeValid) {
            try {
                System.out.println("Please enter grade: ");
                double grade = scanner.nextDouble();
                if (grade >= 0 && grade <= 10) {
                    student.setGrade(grade);
                    isGradeValid = true;
                } else {
                    System.out.println("Invalid grade. Grade must be between 0 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine();
        studentList.add(student);
        System.out.println("New student " + student.getName() + " successfully added");

    }

    public static void removeStudent() {

       // if (id < 1 || id > studentList.size()) {
        //    System.out.println("No student found with id " + id);
      //  } else {
        if(studentList.size() != 0){
            System.out.println("Enter student id to be removed");
            int id = scanner.nextInt();
            Iterator<Student> iterator = studentList.iterator();

            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getId() == id) {
                    iterator.remove();
                    System.out.println("Student " + student.getName() + " successfully removed");
                    scanner.nextLine();
                    break; // Assuming student IDs are unique, we can stop iterating after removal
                }
                else {
                    System.out.println("No student found with id " + id);
                    scanner.nextLine();
                    break;
                }
            }

        } else {
            System.out.println("There are no students yet, please start adding before remove.");

        }


    }

    public static void updateStudentDetails() {
        System.out.println("Enter student id to be changed");
        int id = scanner.nextInt();
        if (id < 1 || id > studentList.size()) {
            System.out.println("No student found with id " + id);
        } else {
            for (Student student : studentList) {
                if (student.getId() == id) {
                    scanner.nextLine();
                    System.out.println("Enter new name");
                    student.setName(scanner.nextLine());
                    System.out.println("Enter new age");
                    student.setAge(scanner.nextInt());
                    System.out.println("Enter new grade");
                    student.setGrade(scanner.nextDouble());
                    System.out.println(student.getName() + "'s details successfully updated");
                }

            }


        }

    }

    public static void listAllStudents() {
        if (studentList.size() == 0) {
            System.out.println("There are no students yet, please start adding.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

    }

}
