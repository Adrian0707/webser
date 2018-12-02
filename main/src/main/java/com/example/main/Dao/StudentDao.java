package com.example.main.Dao;

import com.example.main.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void upadeStudentByID(Student student);

    void removeStudentById(int id);

    void insertStudent(Student student);
}
