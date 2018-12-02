package com.example.main.Dao;


import com.example.main.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "adrian", "IT"));
                put(2, new Student(2, "adritan", "IT"));
                put(3, new Student(3, "adriarn", "IT"));
                put(4, new Student(4, "adriean", "IT"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();

    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void upadeStudentByID(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);

    }

    @Override
    public void removeStudentById(int id) {

        students.remove(id);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
