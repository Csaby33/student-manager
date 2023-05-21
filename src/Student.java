/**
 * Represents a student with a unique ID, name, age, and grade.
 */
public class Student {
    private static int lastAssignedId = 1;
    private String name;
    private final int id;
    private int age;
    private double grade;

    public Student() {
        this.id = lastAssignedId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
