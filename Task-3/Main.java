import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Load from File");
            System.out.println("7. Save to File");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    Student student = new Student(id, name, age, grade, address);
                    try {
                        manager.addStudent(student);
                        System.out.println("Student added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    try {
                        manager.removeStudent(removeId);
                        System.out.println("Student removed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter new name (leave blank to keep current): ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age (leave blank to keep current): ");
                    String newAgeStr = scanner.nextLine();
                    int newAge = newAgeStr.isEmpty() ? -1 : Integer.parseInt(newAgeStr);
                    System.out.print("Enter new grade (leave blank to keep current): ");
                    String newGrade = scanner.nextLine();
                    System.out.print("Enter new address (leave blank to keep current): ");
                    String newAddress = scanner.nextLine();
                    try {
                        manager.updateStudent(updateId, newName.isEmpty() ? null : newName, newAge, newGrade.isEmpty() ? null : newGrade, newAddress.isEmpty() ? null : newAddress);
                        System.out.println("Student updated successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = manager.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    System.out.print("Enter filename to load from: ");
                    String loadFilename = scanner.next();
                    manager.loadFromFile(loadFilename);
                    System.out.println("Data loaded successfully.");
                    break;
                case 7:
                    System.out.print("Enter filename to save to: ");
                    String saveFilename = scanner.next();
                    manager.saveToFile(saveFilename);
                    System.out.println("Data saved successfully.");
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
