package com.example.spring_sda.repositories;

import com.example.spring_sda.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //select * from student where student.surname = surname
    List<String> findBySurname(String surname);


    @Query(value = "select s from Student s where s.studentName like %:keyword%")
    List<Student> searchByName(String keyword);

    @Query(value = "select s from Student s where  s.studentName = 'Petrino'")
    List<Student> findAllNamedPetrino();


}
