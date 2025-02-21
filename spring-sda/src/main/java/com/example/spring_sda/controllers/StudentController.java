package com.example.spring_sda.controllers;

import com.example.spring_sda.entities.Student;
import com.example.spring_sda.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentService service;


    //get all students
    @GetMapping
    public String getAllStudents(Model model){
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    //create students
    @GetMapping("/create")
    public String goToAddStudent(Model model){
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("student") Student student){
        service.addStudent(student);
        return "redirect:/students";
    }


    //update students
    @GetMapping("/update/{id}")
    public String goToUpdateStudent(Model model, @PathVariable Long id){
        model.addAttribute("student", service.getStudentById(id));
        return "update_students";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute("student") Student student, Student updatedStudent){
        service.updateStudent(student.getId(), updatedStudent);
        return "redirect:/students";
    }


    //delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

    // search students by name containing a keyword
    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = service.searchStudentsByName(keyword);
        model.addAttribute("students", students);
        return "index";
    }

    // students named 'Petrino' (as an example)
    @GetMapping("/petrino")
    public String findAllNamedPetrino(Model model) {
        List<Student> students = service.getAllPetrinos();
        model.addAttribute("students", students);
        return "index";
    }



}
