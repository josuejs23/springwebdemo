package com.josuejs.springwebdemo.rest;

import com.josuejs.springwebdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        return  List.of( new Student(1, "Josue", "Zorrilla"),
                new Student(2, "Lili", "Zorrilla")
        );
    }
}
