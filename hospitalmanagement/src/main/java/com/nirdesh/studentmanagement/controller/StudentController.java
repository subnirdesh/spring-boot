package com.nirdesh.studentmanagement.controller;

import com.nirdesh.studentmanagement.entity.Student;
import com.nirdesh.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping(path = "/id/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @GetMapping(path="/firstname/{firstName}")
    public List<Student> getStudentbyFirstName(@PathVariable String firstName){
        return studentService.findByFirstName(firstName);

    }


    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping(path = "/id/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping(path="id/{id}")
    public void deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
    }
}
