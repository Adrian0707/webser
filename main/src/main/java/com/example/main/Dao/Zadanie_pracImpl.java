package com.example.main.Dao;


import com.example.main.Entity.Zadanie_prac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("zadanie_pracSql")
public class Zadanie_pracImpl implements Zadanie_pracDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class Zadanie_pracRowMapper implements RowMapper<Zadanie_prac> {

        @Override
        public Zadanie_prac mapRow(ResultSet resultSet, int i) throws SQLException {
            Zadanie_prac zadanie_prac = new Zadanie_prac(resultSet.getInt("id"), resultSet.getInt("id_zglosz"), resultSet.getInt("id_prac"));

            return zadanie_prac;
        }
    }

    @Override
    public Collection<Zadanie_prac> getAllZadanie_prac() {
        // select column name from table name
        final String sql = "SELECT id,id_zglosz, id_prac FROM zadania_prac";
        List<Zadanie_prac> zadanie_prac = jdbcTemplate.query(sql, new Zadanie_pracRowMapper());
        return zadanie_prac;
    }


    @Override
    public Zadanie_prac getZadanie_pracById(int id) {
        // select column name from table namw where column = value
        final String sql = "SELECT id,id_zglosz, id_prac FROM zadania_prac where id=?";
        Zadanie_prac zadanie_prac = jdbcTemplate.queryForObject(sql, new Zadanie_pracRowMapper(), id);
        return zadanie_prac;
    }


    @Override
    public void upadeZadanie_pracById(Zadanie_prac zadanie_prac) {
        //upade table set column=value .... where column=value

        final String sql = "update zadania_prac set id_zglosz=?, id_prac=? where (id=?)";
        int id = zadanie_prac.getId();
        int id_prac = zadanie_prac.getId_prac();
        int id_zglosz = zadanie_prac.getId_zglosz();
        jdbcTemplate.update(sql, id_zglosz, id_prac, id);


    }

    @Override
    public void removeZadanie_pracById(int id) {
//DELETE FROM NAME WHERE COLUMN = VALUE
        final String sql = " delete from zadania_prac where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertZadanie_prac(Zadanie_prac zadanie_prac) {
        //insert into table columns (...) values (...)
        final String sql = "insert into zadania_prac (id,id_prac,id_zglosz) Values (?,?,?)";
        final int id = zadanie_prac.getId();
        final int id_prac = zadanie_prac.getId_prac();
        final int id_zglosz = zadanie_prac.getId_zglosz();
        jdbcTemplate.update(sql, id, id_prac, id_zglosz);


    }


}
