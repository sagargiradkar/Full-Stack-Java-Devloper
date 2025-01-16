package in.ineuron.controller;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.ineuron.service.IStudentService;
import in.ineuron.bo.StudentBO;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService service = factory.getBean(IStudentService.class);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Student by ID");
            System.out.println("5. Get All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    StudentBO newStudent = new StudentBO();
                    scanner.nextLine(); // Clear buffer
                    
                    System.out.print("Enter student name: ");
                    newStudent.setSname(scanner.nextLine());
                    
                    System.out.print("Enter student address: ");
                    newStudent.setSaddress(scanner.nextLine());
                    
                    System.out.print("Enter student age: ");
                    newStudent.setSage(scanner.nextInt());
                    
                    int result = service.insert(newStudent);
                    System.out.println("Student added with ID: " + result);
                    break;

                case 2:
                    // Update Student
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    StudentBO updateStudent = service.getStudent(updateId);
                    
                    if (updateStudent != null) {
                        scanner.nextLine(); // Clear buffer
                        
                        System.out.print("Enter new name: ");
                        updateStudent.setSname(scanner.nextLine());
                        
                        System.out.print("Enter new address: ");
                        updateStudent.setSaddress(scanner.nextLine());
                        
                        System.out.print("Enter new age: ");
                        updateStudent.setSage(scanner.nextInt());
                        
                        service.update(updateStudent);
                        System.out.println("Student updated successfully");
                    } else {
                        System.out.println("Student not found with ID: " + updateId);
                    }
                    break;

                case 3:
                    // Delete Student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    StudentBO studentToDelete = service.getStudent(deleteId);
                    
                    if (studentToDelete != null) {
                        service.delete(studentToDelete);
                        System.out.println("Student deleted successfully");
                    } else {
                        System.out.println("Student not found with ID: " + deleteId);
                    }
                    break;

                case 4:
                    // Get Student by ID
                    System.out.print("Enter student ID: ");
                    int getId = scanner.nextInt();
                    StudentBO student = service.getStudent(getId);
                    
                    if (student != null) {
                        System.out.println("Student details:");
                        System.out.println("ID: " + student.getSid());
                        System.out.println("Name: " + student.getSname());
                        System.out.println("Address: " + student.getSaddress());
                        System.out.println("Age: " + student.getSage());
                    } else {
                        System.out.println("Student not found with ID: " + getId);
                    }
                    break;

                case 5:
                    // Get All Students
                    List<StudentBO> students = service.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found in the database");
                    } else {
                        System.out.println("\nAll Students:");
                        System.out.println("----------------------------------------");
                        for (StudentBO s : students) {
                            System.out.println("ID: " + s.getSid());
                            System.out.println("Name: " + s.getSname());
                            System.out.println("Address: " + s.getSaddress());
                            System.out.println("Age: " + s.getSage());
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;

                case 6:
                    // Exit
                    running = false;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
        ((ConfigurableApplicationContext) factory).close();
    }
}
