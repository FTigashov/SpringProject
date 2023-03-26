package ru.personal.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.personal.SpringProject.entities.Student;
import ru.personal.SpringProject.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String findAll(Model model) {
        List<Student> students = service.findAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/student-create")
    public String createStudentForm(Student student) {
        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student-delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/student-update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        return "/student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }
}