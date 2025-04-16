import java.io.*;
import java.util.*;

// OOP - Student class
class Student {
    String name;
    String rollNo;
    String emailId;
    int age;
    String section;
    String department;

    // Constructor
    Student(String name, String rollNo, String emailId, int age, String section, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.emailId = emailId;
        this.age = age;
        this.section = section;
        this.department = department;
    }

    // Convert student object to string (for file)
    @Override
    public String toString() {
        return name + "," + rollNo + "," + emailId + "," + age + "," + section + "," + department;
    }

    // Convert string back to student object
    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5]);
    }
}

// Main class
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter Student Details ===");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Roll No: ");
        String rollNo = sc.nextLine();

        System.out.print("Email ID: ");
        String emailId = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();  // consume newline

        System.out.print("Section: ");
        String section = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        // Create Student object
        Student student = new Student(name, rollNo, emailId, age, section, department);

        // (Threading and file handling will be added in next part)
        System.out.println("\nStudent Data:");
        System.out.println(student);  // just printing object for now
    }
}
