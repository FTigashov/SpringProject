package ru.personal.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.personal.SpringProject.entities.Student;
import ru.personal.SpringProject.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student findById(Long id) {
        return repository.getById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}