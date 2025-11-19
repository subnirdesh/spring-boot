package com.nirdesh.studentmanagement.service.impl;

import com.nirdesh.studentmanagement.entity.Student;
import com.nirdesh.studentmanagement.repository.StudentRepository;
import com.nirdesh.studentmanagement.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl  implements StudentService {
    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();

    }

    @Override
    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public List<Student> findByFirstNameContaining(String firstName){
        return studentRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public Student findByEmailAddress(String email){
        return studentRepository.getStudentByEmailAddress(email);
    }

@Override
    public Student updateStudent(Integer id,Student newStudent){
        Student student =  findById(id);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail_address(newStudent.getEmail_address());
        student.setGuardianName(newStudent.getGuardianName());
        student.setGuardianPhone(newStudent.getGuardianPhone());

        return studentRepository.save(student);

    }

    @Override
    public int updateFirstNameById(Integer id, String firstName){
        return studentRepository.updateFirstNameByID(id,firstName);
    }

    @Override
    public void deleteStudent(Integer id){

        studentRepository.deleteById(id);
    }
}




