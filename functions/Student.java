package functions;

public class Student {
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // Your code goes here
    public void printFullName() {
         System.out.println(this.firstName + " " + this.lastName);
    }
}
