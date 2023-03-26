package ru.personal.SpringProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.personal.SpringProject.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}