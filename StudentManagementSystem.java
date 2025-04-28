import java.util.ArrayList;
import java.util.Scanner;

// Represents a student
class Student {
    private String id;
    private String name;
    private int age;
    private String grade;
    private String address;

    public Student(String id, String name, int age, String grade, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade + ", Address: " + address;
    }
}

// Manages student records
class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a new student
    public void addStudent() {
        System.out.println("Enter student details:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();

        Student newStudent = new Student(id, name, age, grade, address);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student Records:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Update a student's record
    public void updateStudent() {
        System.out.print("Enter the ID of the student to update: ");
        String idToUpdate = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(idToUpdate)) {
                System.out.println("Enter new details:");
                System.out.print("Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Grade: ");
                student.setGrade(scanner.nextLine());
                System.out.print("Address: ");
                student.setAddress(scanner.nextLine());
                System.out.println("Student record updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + idToUpdate + " not found.");
    }

    // Delete a student's record
    public void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        String idToDelete = scanner.nextLine();
        students.removeIf(student -> student.getId().equals(idToDelete));
        System.out.println("Student record deleted successfully!");
    }

    // Search for a student by ID or Name
    public void searchStudent() {
        System.out.print("Enter ID or Name to search: ");
        String searchQuery = scanner.nextLine();
        System.out.println("Search Results:");
        for (Student student : students) {
            if (student.getId().equals(searchQuery) || student.getName().equals(searchQuery)) {
                System.out.println(student);
            }
        }
    }
}

// Main class to run the application
public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    manager.updateStudent();
                    break;
                case 4:
                    manager.deleteStudent();
                    break;
                case 5:
                    manager.searchStudent();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
