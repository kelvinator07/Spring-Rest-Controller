package com.geekykel.springrestcontroller;

import com.geekykel.springrestcontroller.entities.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeRestController {

    List<Student> students;

    @RequestMapping("/hello")
    public String sayHello() {

        return "Hello Rest API";
    }

    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student(1, "Kelvin", "Geeky", "geeky@gmail.com"));
        students.add(new Student(2, "Chad", "Bath", "chadbath@gmail.com"));
        students.add(new Student(3, "Lekan", "Puzzles", "lekanp@gmail.com"));
        students.add(new Student(4, "Samson", "Toba", "sam4real@gmail.com"));
        students.add(new Student(5, "Tobi", "Osunibi", "tbaba@gmail.com"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= students.size()) || (studentId < 0) )
            throw new StudentNotFoundException("Student With Id " + studentId + " Not Found");

        return students.get(studentId);
    }

}
