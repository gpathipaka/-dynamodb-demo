package com.gp.ddb.resource;

import com.gp.ddb.domain.Student;
import com.gp.ddb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentResource {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("{studentid}")
    public Student getStudent() {
        Student st = new Student();
        return st;
    }

    @PostMapping
    public String insertIntoDDB(@RequestBody Student student) {
        studentRepository.insertStudent(student);
        return "Successfull";
    }
}
