package com.nirdesh.studentmanagement.controller;

import com.nirdesh.studentmanagement.entity.Student;
import com.nirdesh.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping(path="/email/{email}")
    public Student getStudentbyEmailAddress(@PathVariable String email){
        return studentService.findByEmailAddress(email);

    }


    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/id/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @PatchMapping("/firstName/{id}")
    public int updateFirstNameById(@PathVariable Integer id, @RequestBody Map<String,String> updates){
        String firstName=updates.get("firstName");
        return studentService.updateFirstNameById(id,firstName);
    }

    @DeleteMapping("id/{id}")
    public void deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
    }
}
