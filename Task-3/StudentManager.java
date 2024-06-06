import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists.");
            }
        }
        students.add(student);
    }

    public void removeStudent(int id) {
        Student student = searchStudent(id);
        if (student != null) {
            students.remove(student);
        } else {
            throw new IllegalArgumentException("No student found with ID " + id);
        }
    }

    public void updateStudent(int id, String name, int age, String grade, String address) {
        Student student = searchStudent(id);
        if (student != null) {
            if (name != null) student.setName(name);
            if (age > 0) student.setAge(age);
            if (grade != null) student.setGrade(grade);
            if (address != null) student.setAddress(address);
        } else {
            throw new IllegalArgumentException("No student found with ID " + id);
        }
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String grade = parts[3].trim();
                String address = parts[4].trim();
                students.add(new Student(id, name, age, grade, address));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getId() + ", " + student.getName() + ", " + student.getAge() + ", " + student.getGrade() + ", " + student.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
