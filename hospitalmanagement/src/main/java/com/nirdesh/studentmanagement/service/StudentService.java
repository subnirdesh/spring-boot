package com.nirdesh.studentmanagement.service;

import com.nirdesh.studentmanagement.entity.Student;
import com.nirdesh.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();

    }

    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    public Student updateStudent(Integer id,Student newStudent){
        Student student =  findById(id);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail_address(newStudent.getEmail_address());
        student.setGuardianName(newStudent.getGuardianName());
        student.setGuardianPhone(newStudent.getGuardianPhone());

        return studentRepository.save(student);

    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
}
