package com.example.main.Service;


import com.example.main.Dao.StudentDao;
import com.example.main.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("mysql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return studentDao.getAllStudents();

    }

    public Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        studentDao.removeStudentById(id);
    }

    public void upadeStudentByID(Student student) {
        studentDao.upadeStudentByID(student);

    }

    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

}
