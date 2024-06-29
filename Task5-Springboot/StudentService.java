package com.example.student_management.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> updateStudent(int id, Student student) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(student.getName());
                    existingStudent.setAge(student.getAge());
                    existingStudent.setGrade(student.getGrade());
                    existingStudent.setAddress(student.getAddress());
                    return studentRepository.save(existingStudent);
                });
    }

    public boolean deleteStudent(int id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return true;
                })
                .orElse(false);
    }
}
