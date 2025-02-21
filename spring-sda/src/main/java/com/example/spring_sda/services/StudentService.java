package com.example.spring_sda.services;

import com.example.spring_sda.entities.Student;
import com.example.spring_sda.repositories.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Student student = getStudentById(id);
        student.setStudentName(updatedStudent.getStudentName());
        student.setSurname(updatedStudent.getSurname());
        student.setAge(updatedStudent.getAge());
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    public List<String> getStudentsBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.searchByName(name);
    }
    public List<Student> getAllPetrinos() {
        return studentRepository.findAllNamedPetrino();
    }
}
