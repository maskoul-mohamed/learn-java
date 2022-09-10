package functions;

public class Example2 {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student("Mohamed", "Maskoul"),
            new Student("test 2", "test 2"),
            new Student("test 3", "test ."),
        };

        for (Student s : students) {
            s.printFullName();
        }
    }
}
