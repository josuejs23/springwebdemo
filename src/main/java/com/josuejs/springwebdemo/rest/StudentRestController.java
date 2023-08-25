package com.josuejs.springwebdemo.rest;

import com.josuejs.springwebdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    @PostConstruct
    public void loadData(){
        this.studentList = List.of( new Student(1, "Josue", "Zorrilla"),
                new Student(2, "Lili", "Zorrilla"));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return  studentList;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentList.stream()
                .filter( student1 -> student1.getId() == id)
                .findFirst()
                .orElseThrow(()->new StudentNotFoundException("Student with id %d not found".formatted(id)));
    }


}
