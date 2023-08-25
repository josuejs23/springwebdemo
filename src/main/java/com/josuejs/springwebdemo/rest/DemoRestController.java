package com.josuejs.springwebdemo.rest;

import com.josuejs.springwebdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return  List.of( new Student(1, "Josue", "Zorrilla"),
                new Student(2, "Lili", "Zorrilla")
        );
    }
}
