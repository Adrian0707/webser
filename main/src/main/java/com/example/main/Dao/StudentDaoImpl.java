package com.example.main.Dao;

import com.example.main.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));

            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        // select column name from table name
        final String sql = "SELECT id, name, course FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Student getStudentById(int id) {
        // select column name from table namw where column = value
        final String sql = "select id,name,course from students where id=?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public void upadeStudentByID(Student student) {
        //upade table set column=value .... where column=value
        final String sql = "update students set name=?, course=? where id=?";
        int id = student.getId();
        String name = student.getName();
        String course = student.getCourse();
        jdbcTemplate.update(sql, name, course, id);


    }

    @Override
    public void removeStudentById(int id) {
//DELETE FROM NAME WHERE COLUMN = VALUE
        final String sql = " delete from students where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertStudent(Student student) {
        //insert into table columns (...) values (...)
        final String sql = "insert into students (id,name,course) Values (?,?,?)";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, id, name, course);


    }
}
